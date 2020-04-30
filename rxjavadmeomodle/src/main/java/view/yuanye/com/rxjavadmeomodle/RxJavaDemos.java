package view.yuanye.com.rxjavadmeomodle;


import java.util.ArrayList;
import java.util.List;

import fram.lib.utils.log.KLog;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

/**
 * Rx JAVA 示例代码
 */
public class RxJavaDemos {
    public static String tag = "rxJAVADemos";


    public static  Observer  getObserver(){


        return   new Observer<Integer>() {


            @Override
            public void onSubscribe(Disposable d) {

                KLog.e(tag, "onSubscribe  Disposable" + d);
            }

            @Override
            public void onNext(Integer integer) {

                KLog.e(tag, "onSubscribe  integer" + integer);
            }

            @Override
            public void onError(Throwable e) {

                KLog.e(tag, "onSubscribe  Throwable" + e.getMessage());
            }

            @Override
            public void onComplete() {
                KLog.e(tag, "onSubscribe  onComplete");
            }
        } ;
    }



    /**
     * RX java 基本使用
     */

    public static void demo_01_creat() {

        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {

                KLog.e(tag, "e.isDisposed():" + e.isDisposed());
                KLog.e(tag, "ObservableEmitter 。。1");
                e.onNext(1);
                KLog.e(tag, "ObservableEmitter 。。2");
                e.onNext(2);
                KLog.e(tag, "ObservableEmitter 。。error");
                e.onError(new NullPointerException("测试"));
                KLog.e(tag, "ObservableEmitter 。。complete");
                e.onComplete();


            }
        }).subscribe(getObserver());

    }



    public static void demo_02_just(){

        Observable.just(1,2,3,4,5,6).subscribe(getObserver()) ;
    }

    public static void demo_03_from_array(){

            Integer integers [] = {1,23,4,5,6} ;

        Observable.fromArray(integers).subscribe(getObserver());
    }

    public static  void demo_04_fromIterable(){
        List<Integer> list = new ArrayList<>() ;
        list.add(1);
        list.add(2);

        Observable.fromIterable(list).subscribe(getObserver());
    }

    public static  void  demo_05_map(){

        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {

                e.onNext(1);
                e.onNext(2);

            }
        }).map(new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) throws Exception {
                KLog.e(tag,"map...");
                return integer+"";
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {

                KLog.e(tag,"s-->"+s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        }) ;
    }

    public static  void test_demo_flatMap(){

        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
            }

            // 使用Map变换操作符中的Function函数对被观察者发送的事件进行统一变换：整型变换成字符串类型
        }).flatMap(new Function<Integer,  ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(Integer integer) throws Exception {

                KLog.e(tag,"flatmap"+integer);
                final List<String> list = new ArrayList<>();
                for (int i = 0; i < 3; i++) {
                    list.add("我是事件 " + integer + "拆分后的子事件" + i);
                    // 通过flatMap中将被观察者生产的事件序列先进行拆分，再将每个事件转换为一个新的发送三个String事件
                    // 最终合并，再发送给被观察者
                }
                return Observable.fromIterable(list);

            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                KLog.e(tag, "开始采用subscribe连接");
            } // 默认最先调用复写的 onSubscribe（）

            @Override
            public void onNext(String value) {
                KLog.e(tag, "接收到了事件" + value);
            }

            @Override
            public void onError(Throwable e) {
                KLog.e(tag, "对Error事件作出响应");
            }

            @Override
            public void onComplete() {
                KLog.e(tag, "对Complete事件作出响应");
            }
        });
    }

    public static  void test_demo_concatMap(){

        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
            }

            // 使用Map变换操作符中的Function函数对被观察者发送的事件进行统一变换：整型变换成字符串类型
        }).concatMap(new Function<Integer,  ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(Integer integer) throws Exception {
                KLog.e(tag,"concatMap"+integer);
                final List<String> list = new ArrayList<>();
                for (int i = 0; i < 3; i++) {
                    list.add("我是事件 " + integer + "拆分后的子事件" + i);
                    // 通过flatMap中将被观察者生产的事件序列先进行拆分，再将每个事件转换为一个新的发送三个String事件
                    // 最终合并，再发送给被观察者
                }
                return Observable.fromIterable(list);

            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                KLog.d(tag, "开始采用subscribe连接");
            } // 默认最先调用复写的 onSubscribe（）

            @Override
            public void onNext(String value) {
                KLog.d(tag, "接收到了事件：" + value);
            }

            @Override
            public void onError(Throwable e) {
                KLog.d(tag, "对Error事件作出响应");
            }

            @Override
            public void onComplete() {
                KLog.d(tag, "对Complete事件作出响应");
            }
        });

    }
}
