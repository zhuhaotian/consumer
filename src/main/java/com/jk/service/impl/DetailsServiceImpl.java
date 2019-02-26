package com.jk.service.impl;

import com.jk.bean.ShopCar;
import com.jk.bean.Sku;
import com.jk.bean.User;
import com.jk.mapper.DetailsMapper;
import com.jk.service.DetailsService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class DetailsServiceImpl implements DetailsService {

    @Resource
    private DetailsMapper detailsMapper;

    @Resource
    private RedisTemplate<String, List<ShopCar>> redisTemplate;

    @Override
    public List querydetails(Integer shpid) {

        return detailsMapper.querydetails(shpid);
    }

//    private void setCookie(HttpServletResponse response, int time, String cookieKey) {
//        Cookie cookie = new Cookie(Constant.tourist_key + Constant.uuid, cookieKey);
//        //设置在根目录就可以访问
//        cookie.setPath("/");
//        //设置过期时间    单位：秒
//        cookie.setMaxAge(time);
//        //将自定义的cookie放到响应头  存放在浏览器内存中
//        response.addCookie(cookie);
//    }
//
//    @Override   //id   ,数量   skuid  ,
//    public void insertGoods(ShopCar shopCar, HttpServletResponse response, HttpServletRequest request, HttpSession session) {
//        User userName = (User) session.getAttribute("user111");
//        List<ShopCar> list = new ArrayList<>();
//
//        Cookie[] cookies = request.getCookies();
//
//        if (userName == null) {       // 1.没有登录    以游客身份储存   2.没有登录  但是已经储存 了
//
//            setCookie(response, 3000, Constant.tourist_key + Constant.uuid);
//
//            //如果 Redis  里面存在 对应的  key值
//            if (redisTemplate.hasKey(Constant.tourist_key + Constant.uuid)) {
//                //直接取出该key对应的value
//                list = redisTemplate.opsForValue().get(Constant.tourist_key + Constant.uuid);
//
//                Iterator<ShopCar> iterator = list.iterator();
//                //判断是否有下一个存在
//                if (iterator.hasNext()) {
//                    //找到当前循环到的对象
//                    ShopCar redisShopKey = iterator.next();
//                    //如果传过来的 sku 名称和当前 的一致   则  判断当前的 商品已存在
//                    if (shopCar.getSku_mch().equals(redisShopKey.getSku_mch())) {
//                        //如果一致就给当前的商品数量 加上传过来的 数量  tjshl
//                        shopCar.setTjshl(shopCar.getTjshl() + redisShopKey.getTjshl());
//                        //把得到的数据  存到 list集合  里面
//                        list.add(redisShopKey);
//                        iterator.remove();
//                    } else {               //sku 名称不存在   则直接存到 Redis里面
//                        list.add(shopCar);
//                    }
//                }      //如果没有下一个存在
//                    redisTemplate.opsForValue().set(Constant.tourist_key + Constant.uuid, list, 30, TimeUnit.MINUTES);
//
//            } else {   // 如果 Redis 里面不存在对应的 key值
//
//                redisTemplate.opsForValue().set(Constant.tourist_key + Constant.uuid, list, 30, TimeUnit.MINUTES);
//                list.add(shopCar);
//            }
//        } else {   //如果当前用户登录
//            shopCar.setId(userName.getId());
//            //获取到所有的cookie
//            Cookie[] cookiesUser = request.getCookies();
//            if (cookiesUser != null) {
//                for (Cookie cookie : cookiesUser) {
//                    //如果当前  cookie key值与存入的cookie名称一致
//                    if (cookie.getName().equals(Constant.tourist_key + Constant.uuid)) {
//                        //判断当前  key  是否存在
//                        //存在就合并
//                        if (redisTemplate.hasKey(Constant.tourist_key + Constant.uuid)) {
//                            //  redisTemplate.opsForValue().get()
//                            List<ShopCar> shopCars = redisTemplate.opsForValue().get(Constant.tourist_key + Constant.uuid);
//                            //迭代器遍历
//                            Iterator<ShopCar> iterator = shopCars.iterator();
//                            if (iterator.hasNext()) {
//                                //循环当前对象
//                                ShopCar nextShop = iterator.next();
//                                //不存在   就去数据库查询  然后合并  并缓存到  Redis 里
//                                if (redisTemplate.hasKey(Constant.remember_pwd + userName.getId())) {
//                                    List<ShopCar> shopCars1 = redisTemplate.opsForValue().get(Constant.remember_pwd + userName.getId());
//                                    Iterator<ShopCar> iterator1 = shopCars1.iterator();
//                                    if (iterator1.hasNext()) {
//                                        ShopCar next1 = iterator1.next();
//                                        if (next1.getSku_mch().equals(nextShop.getSku_mch())) {
//                                            //修改该对象  数量   加新传过来的数量
//                                            nextShop.setTjshl(nextShop.getTjshl() + shopCar.getTjshl());
//                                            //存到 list 集合里
//                                            shopCars1.add(nextShop);
//                                            //  并  将之前的 从Redis里移除
//                                            iterator1.remove();
//                                        }
//                                    }
//                                }
//                                //查询数据库中购物车的 全部商品信息
//                                List<ShopCar> shopCarsUser = detailsMapper.queryGoodsByUser(userName);
//                                Iterator<ShopCar> iterator1 = shopCarsUser.iterator();
//                                if (iterator1.hasNext()) {
//                                    ShopCar next1 = iterator1.next();
//                                    //如果redis中对象有与mysql数据库中已存在的对象sku名称一致
//                                    if (nextShop.getSku_mch() == next1.getSku_mch()) {
//                                        //修改 数据库  商品的数量
//                                        next1.setTjshl(next1.getTjshl() + shopCar.getTjshl());
//                                        detailsMapper.updateTjshlBy(next1);
//                                    } else {
//                                        //如果redis中对象有与mysql数据库中不存在的对象sku
//                                        //新增mysql数据库
//                                        detailsMapper.addShopGoods(next1);
//                                    }
//                                }
//                            }
//                        } else { //redis中不存在该key     去数据库查询   缓存到redis中
//                            List<ShopCar> lsit = detailsMapper.queryGoodsByUser(userName);
//                            redisTemplate.opsForValue().set(Constant.remember_pwd + userName.getId(), lsit, 30, TimeUnit.MINUTES);
//                        }
//                    } else{
//                    //cookie中没有对应的key   去数据库查询   缓存到cookie和redis中
//                    List<ShopCar> gouwuList = detailsMapper.queryGoodsByUser(userName);
//                    redisTemplate.opsForValue().set(Constant.remember_pwd + userName.getId(), gouwuList, 30, TimeUnit.MINUTES);
//                    setCookie(response, 3600, Constant.remember_pwd + userName.getId());
//                }
//            }
//        }
//        redisTemplate.opsForValue().set(Constant.remember_pwd + Constant.uuid, list, 30, TimeUnit.MINUTES);
//    }
//}

    @Override
    public List queryimgdetails(Integer shpid) {
        return detailsMapper.queryimgdetails(shpid);
    }

    //查询购物车数据
    @Override
    public List<ShopCar> getShopCar(User user) {
        return detailsMapper.getShopCar(user.getId());
    }

    //修改数据库购物车的数量
    @Override
    public void updateShopCar(ShopCar next) {
        detailsMapper.updateShopCar(next);
    }

    //新怎购物车数据
    @Override
    public void addShopCar(ShopCar next) {
        ShopCar car=detailsMapper.getSkuSpu(next);
        if(car!=null){
            next.setId(car.getId());
            next.setTjshl(car.getTjshl()+next.getTjshl());
            detailsMapper.updateTjshl(next);
        }else{
            next.setHj(next.getSkuJg()*next.getTjshl());
            detailsMapper.addShopCar(next);
        }
    }

    @Override
    public ShopCar getShop(ShopCar sh) {
        return detailsMapper.getShop(sh.getShp_id());
    }


    @Override
    public Sku querySkuById(Integer skuId) {
        Sku car= detailsMapper.getSkuById(skuId);
        return car;
    }

    @Override
    public void addCount(Integer id, Integer tjshl, Double skuJg) {
        Double hj=tjshl*skuJg;
        detailsMapper.addCount(id,hj,tjshl);
    }

    @Override
    public void jianCount(Integer id, Integer tjshl, Double skuJg) {
        Double hj=tjshl*skuJg;
        detailsMapper.addCount(id,hj,tjshl);
    }


    @Override
    public void insertGoods(ShopCar shopCar, HttpServletResponse response, HttpServletRequest request, HttpSession session) {

    }

    //结算
    @Override
    public Double jieSuanCheckPrice(String ids) {
        Double price = detailsMapper.jieSuanCheckPrice(ids);
        return price;
    }

    @Override
    public void deletesShopCar(String ids) {
        detailsMapper.deletesShopCar(ids);
    }

    @Override
    public void addShopCar2(List<ShopCar> list2) {
        detailsMapper.addShopCar2(list2);
    }

    @Override
    public List<ShopCar> getShopCar2() {
        return detailsMapper.getShopCar2();
    }

    @Override
    public ShopCar getShopCar33(List<ShopCar> list2) {
        return null;
    }

    @Override
    public void updateShop(List<ShopCar> list2) {

    }

    @Override
    public void deletesShopCar2(Integer id) {
        detailsMapper.deletesShopCar2(id);
    }

}
