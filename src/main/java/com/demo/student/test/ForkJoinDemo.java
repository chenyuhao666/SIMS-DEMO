package com.demo.student.test;

import java.util.concurrent.*;

/**
 * @Author: chenyuhao
 * @Date: 2019/7/15 14:01
 * @Version 1.0
 */
public class ForkJoinDemo {

    private static class MaxNumber extends RecursiveTask<Integer>{

        private int threshold = 15;

        private int[] array;

        private int index0 = 0;
        private int index1 = 0;

        public MaxNumber(int[] array, int index0, int index1) {
            this.array = array;
            this.index0 = index0;
            this.index1 = index1;
        }

        @Override
        protected Integer compute() {
            int max = Integer.MIN_VALUE;
            if ((index1 - index0) <= threshold) {
                System.out.println(index0 + " ~ " + index1 + "任务执行" );
                for (int i = index0;i <= index1; i ++) {
                    System.out.println(array[i] + "发送撤单请求");
                    max = max + array[i];
                }

            } else {
                //fork/join
                int mid = index0 + (index1 - index0) / 2;
                MaxNumber lMax = new MaxNumber(array, index0, mid);
                MaxNumber rMax = new MaxNumber(array, mid + 1, index1);

                lMax.fork();
                rMax.fork();

                int lm = lMax.join();
                int rm = rMax.join();

                max = lm + rm;

            }

            return max;
        }
    }

    /**public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ForkJoinPool pool = new ForkJoinPool();
        int[] array = new int[1000];
        for(int i = 0 ; i < 1000 ; i ++){
            array[i] = i;
        }
        long startTime1 = System.currentTimeMillis();
        MaxNumber task = new MaxNumber(array, 0, array.length - 1);
        Future<Integer> future = pool.submit(task);
        long endTime2 = System.currentTimeMillis();
        System.out.println("Result:" + future.get(1, TimeUnit.SECONDS));
        System.out.println("ResultTime:" + (endTime2 - startTime1));
    }**/
}
