package _Final_Exam.Repository;


import _Final_Exam.Model.ImProduct;
import _Final_Exam.NotFoundProductException.NotFoundProductException;


import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class ImProductRepoImpl implements ProductRepository<ImProduct> {
    private final static String IMPRODUCT_PATH = "D:\\CodeGym\\module2\\src\\_Final_Exam\\Data\\ImProductData.csv";
    private final static List<ImProduct> imProducts = new ArrayList<>();

    public ImProductRepoImpl() {
        try {
            readCSV();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(ImProduct imProduct) {
        imProduct.setId(imProducts.size() + 1);
        imProducts.add(imProduct);
        writeCSV();
    }

    @Override
    public List<ImProduct> findAll() {
        return imProducts;
    }

    @Override
    public boolean deleteByCode(String code) {
        Iterator<ImProduct> iterator = imProducts.iterator();
        if (iterator.hasNext()) {

            ImProduct imProduct = iterator.next();

            if (imProduct.getCode().equals(code)) {
                imProducts.remove(imProduct);
                writeCSV();
                return true;
            }
        }

        throw new NotFoundProductException("Not found code of product !!!");
    }

    @Override
    public List<ImProduct> findByNameOrCode(String field) {
        List<ImProduct> res = new ArrayList<>();
        for (ImProduct imProduct : imProducts) {
            if (imProduct.getName().equals(field) || imProduct.getCode().equals(field)) {
                res.add(imProduct);
            }
        }
        return res;
    }

    @Override
    public List<ImProduct> search(Predicate<ImProduct> product) {
        List<ImProduct> res = new ArrayList<>();
        for (ImProduct p : imProducts) {
            if (product.test(p)) {
                res.add(p);
            }
        }
        return res;
    }

    private static void readCSV() throws Exception {
        FileReader fileReader = new FileReader(IMPRODUCT_PATH);
        BufferedReader br = new BufferedReader(fileReader);

        String line = "";
        while ((line = br.readLine()) != null) {
            String[] row = line.split(",");

            int id = Integer.parseInt(row[0]);
            String code = row[1];
            String name = row[2];
            double price = Double.parseDouble(row[3]);
            int amount = Integer.parseInt(row[4]);
            String manufacture = row[5];
            double imPrice = Double.parseDouble(row[6]);
            String province = row[7];
            double tax = Double.parseDouble(row[8]);

            ImProduct imProduct = new ImProduct(id, code, name, price, amount, manufacture, imPrice, province, tax);
            imProducts.add(imProduct);
        }
        br.close();
    }

    private static void writeCSV() {
        try {
            FileWriter fileWriter = new FileWriter(IMPRODUCT_PATH, false);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            for (ImProduct imProduct : imProducts) {
                bw.write(imProduct.getId() + "," + imProduct.getCode() + "," + imProduct.getName() + "," + imProduct.getPrice() + "," + imProduct.getAmount() + ","
                        + imProduct.getManufacture() + "," + imProduct.getImPrice() + "," + imProduct.getProvince() + "," + imProduct.getTax() + "\n");
            }

            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

