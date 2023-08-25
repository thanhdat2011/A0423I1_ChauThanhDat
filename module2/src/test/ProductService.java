package test;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductService {
    private static final String path = "D:\\CodeGym\\module2\\src\\test\\data.bin";
    private List<Product> data = new ArrayList<>();
    private ObjectOutputStream objectOutputStream;

    ProductService() {
        try {
            File file = new File(path);

            if (!file.exists()) {
                file.createNewFile();
            }


            if (file.length() > 0) {
                ObjectInputStream input = new ObjectInputStream(new FileInputStream(path));
                data = (ArrayList) input.readObject();
            }

            objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    void save(Product product) throws IOException {
        if (product.getId() > 0) {
            int index = data.indexOf(product);
            data.set(index, product);
        } else {
            product.setId(data.size() + 1);
            data.add(product);
        }
        objectOutputStream.writeObject(data);
    }

    void add(Product product) throws IOException {
        List<Product> products = getAll();
        product.setId(products.size() + 1);
        products.add(product);

        objectOutputStream.writeObject(products);
    }

    List<Product> getAll() {
        return data;
    }

    List<Product> searchByName(String name) {
        List<Product> res = new ArrayList<>();
        int size = data.size();
        for (int i = 0; i < size; i++) {
            if ((data.get(i).getName().contains(name)))
                res.add(data.get(i));
        }

        return res;
    }

    List<Product> searchFromPrice(double price) {
        return data.stream().filter(e -> e.getPrice() > price).collect(Collectors.toList());
    }

    int deleteByName(String name) {
        int res = 0;
        Optional<Product> product = data.stream().filter(e -> name.equals(e.getName())).findFirst();
        if (product.isPresent()) {
            data.remove(product.get());
            res = product.get().getId();
        }
        return res;
    }

    void deleteById(int id) throws IOException {
        data.removeIf(e -> e.getId() == id);
        objectOutputStream.writeObject(data);
    }

    void update(Product product) throws IOException {
        // use stream update
//        data.stream().forEach(e->{
//            if(e.getId()== product.getId())
//                e.setName(product.getName());
//                e.setBrand(product.getBrand());
//                e.setPrice(product.getPrice());
//                e.setDescription(product.getDescription());
//        });

        // use indexOf
        int index = data.indexOf(product);
        data.set(index, product);
        objectOutputStream.writeObject(data);
    }

    List<Product> sortByPrice() {
        Collections.sort(data);
        return data;
    }
}