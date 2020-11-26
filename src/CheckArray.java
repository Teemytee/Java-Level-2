public class CheckArray {
    public void checkSize(String[][] values) throws MyArraySizeException, MyArrayDataException {
        String sizeError = "Длина массива должен быть равна 4";
        for (String[] value : values) {
            if (value.length != 4) {
                throw new MyArraySizeException(sizeError);
            }
        }
        int sum = 0;
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length; j++) {
                try{
                    sum += Integer.parseInt(values[i][j]);
                } catch (NumberFormatException e){
                    String dataError = "Элемент неправильного формата, индексы: "+ i + ", " + j;
                    throw new MyArrayDataException(dataError);

                }
            }


        }
    }
}
