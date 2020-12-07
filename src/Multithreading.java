public class Multithreading {
    private static final int size = 10000000;
    private static final int h = size / 2;
    private float[] arr = new float[size];

    public void methodOne(){
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.println(System.currentTimeMillis() - a);
    }

    public void methodTwo(){
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }

        float[] a1 = new float[h];
        float[] a2 = new float[h];

        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        Thread threadOne = new Thread(() -> {
            System.out.println("Поток 1 считает");
            calculateArrays(a1);
        });

        Thread threadTwo = new Thread(() -> {
            System.out.println("Поток 2 считает");
            calculateArrays(a2);
        });
        threadOne.start();
        threadTwo.start();

        try{
            threadOne.join();
            threadTwo.join();

        }catch (InterruptedException e){
            e.printStackTrace();
        }


        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        System.out.println(System.currentTimeMillis() - a);
    }

    private float[] calculateArrays(float[] array){
        for (int i = 0; i < array.length; i++) {
            array[i] = (float)(array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        return array;
    }


}
