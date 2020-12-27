package com.example.demo.main;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.demo.entity.User;
import com.example.demo.utils.ThreadCallAbleTest;
import com.example.demo.utils.ThreadTest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class mainTest {



    public static void main(String[] args) throws ExecutionException, InterruptedException {

        List<String> list1 = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            list1.add(i+"");
        }
        Long l = System.currentTimeMillis();

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3000);
//        for (String s : list1) {
//            ThreadTest threadTest = new ThreadTest(s);
//
//            fixedThreadPool.execute(threadTest);
//        }
        ArrayList< FutureTask<String>> objects = new ArrayList<>();

        for (String s : list1) {
            ThreadCallAbleTest<String> threadTest = new ThreadCallAbleTest<String>(s);
            FutureTask<String> futureTask=new FutureTask<>(threadTest);
            fixedThreadPool.submit(futureTask);

            objects.add(futureTask);
        }
      List<String> list2 = new ArrayList();

        for (FutureTask<String> object : objects) {
            System.out.println(object.get());
            list2.add(object.get());

        }
        //Thread.sleep(100);
        System.out.println(list2.size());
        System.out.println(System.currentTimeMillis()-l);

//        List<String> string1 = list1.subList(0, 5000);
//        List<String> string2 = list1.subList(501, 10000);

//        Thread thread = new Thread(() -> {
//
//                try {
//                    System.out.println(Thread.currentThread().getName() + "正在执行");
//                    for (String s : string1) {
//                        Thread.sleep(1000);
//                        System.out.println(s);
//                    }
//
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//        });
//        fixedThreadPool.execute(thread);
//        new Thread(() -> {
//            while (true){
//                try {
//
//                    System.out.println(Thread.currentThread().getName()+"正在执行");
//                    for (String s : string2) {
//                        Thread.sleep(500);
//                        System.out.println(s);
//                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//        BigDecimal bigDecimal = BigDecimal.ZERO;
//        System.out.println(bigDecimal);
//        BigDecimal b = new BigDecimal(0);
//        System.out.println(bigDecimal.compareTo(b) == 0);
//        System.out.println(b);
//
//        List<User> userList = new ArrayList<>();
//        User user1 = new User();
//        User user2 = new User();
//        User user3 = new User();
//        user1.setId("1");
//        user2.setId("2");
//        user3.setId("3");
//        userList.add(user1);
//        userList.add(user3);
//        userList.add(user2);
//        System.out.println(userList);
//        Collections.sort(userList, new Comparator<User>() {
//            @Override
//            public int compare(User o1, User o2) {
//                return Integer.parseInt(o2.getId())-Integer.pars
//                eInt(o1.getId());
//            }
//        });
//        System.out.println(userList);

//        String str = "";
////        String pattern = "(([0-9]+)(([0-9])))";
//        String pattern = "(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})(((0[13578]|1[02])(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)(0[1-9]|[12][0-9]|30))|(02(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))0229)";
//
//        Pattern r = Pattern.compile(pattern);
//        Matcher m = r.matcher(str);
//        System.out.println(m.matches());
     

    }
}
