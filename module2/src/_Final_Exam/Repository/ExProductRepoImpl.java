package _Final_Exam.Repository;

import _Final_Exam.Model.ExProduct;
import _Final_Exam.NotFoundProductException.NotFoundProductException;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class ExProductRepoImpl implements ProductRepository<ExProduct> {
    private final static String EXPRODUCT_PATH = "D:\\CodeGym\\module2\\src\\_Final_Exam\\Data\\ExProductData.csv";
    private final static List<ExProduct> exProducts = new ArrayList<>();

    public ExProductRepoImpl() {
        try {
            readCSV();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(ExProduct exProduct) {
        exProduct.setId(exProducts.size() + 1);
        exProducts.add(exProduct);
        writeCSV();
    }

    @Override
    public List<ExProduct> findAll() {
        return exProducts;
    }

    @Override
    public boolean deleteByCode(String code) {
        Iterator<ExProduct> iterator = exProducts.iterator();
        if (iterator.hasNext()) {

            ExProduct exProduct = iterator.next();

            if (exProduct.getCode().equals(code)) {
                exProducts.remove(exProduct);
                writeCSV();
                return true;
            }
        }
        throw new NotFoundProductException("Not found code of product !!!");
    }

    @Override
    public List<ExProduct> findByNameOrCode(String field) {
        List<ExProduct> res = new ArrayList<>();
        for (ExProduct exProduct : exProducts) {
            if (exProduct.getName().equals(field) || exProduct.getCode().equals(field)) {
                res.add(exProduct);
            }
        }
        return res;
    }

    @Override
    public List<ExProduct> search(Predicate<ExProduct> product) {
        return null;
    }

    private static void readCSV() throws Exception {
        FileReader fileReader = new FileReader(EXPRODUCT_PATH);
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
            double exPrice = Double.parseDouble(row[6]);
            String nation = row[7];

            ExProduct exProduct = new ExProduct(id, code, name, price, amount, manufacture, exPrice, nation);
            exProducts.add(exProduct);
        }
        br.close();
    }

    private static void writeCSV() {
        try {
            FileWriter fileWriter = new FileWriter(EXPRODUCT_PATH, false);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            for (ExProduct exProduct : exProducts) {
                bw.write(exProduct.getId() + "," + exProduct.getCode() + "," + exProduct.getName() + "," + exProduct.getPrice() + "," + exProduct.getAmount() + ","
                        + exProduct.getManufacture() + "," + exProduct.getExPrice() + "," + exProduct.getNation() + "\n");
            }

            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}
