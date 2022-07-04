package br.com.refound.convert;

import br.com.refound.exception.FileReaderException;
import br.com.refound.exception.LineConverterException;
import br.com.refound.model.Order;
import br.com.refound.model.Product;
import br.com.refound.model.User;

import java.io.BufferedReader;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static br.com.refound.util.Constants.*;

public class Convert {

    private Map<Integer, User> users;

    public Collection<User> execute(BufferedReader reader) throws FileReaderException, LineConverterException {
        String line;
        int lineNumber = 1;
        try {
            this.users = new HashMap<>();
            while ((line = reader.readLine()) != null) {
                process(lineNumber++, line);
            }
            return this.users.values();
        }catch (LineConverterException e){
            throw e;
        }catch (Exception e){
            throw new FileReaderException(e);
        }
    }

    private void process(int lineNumber, String line) throws LineConverterException {

        User user;
        Order order;

        Integer idUser, idOrder, idProduct;
        String name, date;
        BigDecimal value;

        idUser = getIntegerValue(lineNumber, line, ID_USER_POS_INI, ID_USER_POS_FIN);

        name = getStringValue(lineNumber, line, NAME_POS_INI, NAME_POS_FIN);

        idOrder = getIntegerValue(lineNumber, line, ID_ORDER_POS_INI, ID_ORDER_POS_FIN);

        idProduct = getIntegerValue(lineNumber, line, ID_PRODUCT_POS_INI, ID_PRODUCT_POS_FIN);

        value = getBigDecimalValue(lineNumber, line, VALUE_POS_INI, VALUE_POS_FIN);

        date = getStringValue(lineNumber, line, DATE_YEAR_POS_INI, DATE_YEAR_POS_FIN)
                + '-' +
                getStringValue(lineNumber, line, DATE_MONTH_POS_INI, DATE_MONTH_POS_FIN)
                + '-' +
                getStringValue(lineNumber, line, DATE_DAY_POS_INI, DATE_DAY_POS_FIN);


        if((user = this.users.get(idUser)) == null){
            user = new User(idUser, name);

            order = new Order(idOrder, date);
            order.addToTotal(value);
            order.getProducts().add(new Product(idProduct, value));
            user.getOrders().put(order.getId(), order);
            this.users.put(user.getId(), user);

        }else {

            if((order =  user.getOrders().get(idOrder)) == null){
                order = new Order(idOrder, date);
                order.addToTotal(value);
                order.getProducts().add(new Product(idProduct, value));

                user.getOrders().put(order.getId(), order);

            }else {
                order.getProducts().add(new Product(idProduct, value));
                order.addToTotal(value);
            }
        }
    }
    public Integer getIntegerValue(int lineNumber, String line, int posIni, int posFin) throws LineConverterException {
        try {
            return Integer.valueOf(line.substring(posIni, posFin));
        }catch (Exception e){
            throw new LineConverterException(lineNumber, e);
        }
    }
    public String getStringValue(int lineNumber, String line, int posIni, int posFin) throws LineConverterException {
        try {
            String value = line.substring(posIni, posFin).trim();

            if (value.isEmpty())
                throw new LineConverterException(lineNumber, new Exception(CONVERT_STRING_EXCEPTION_MSG));

            return value;
        }catch (Exception e){
            throw new LineConverterException(lineNumber, e);
        }
    }
    public BigDecimal getBigDecimalValue(int lineNumber, String line, int posIni, int posFin) throws LineConverterException {
        try {
            return new BigDecimal(line.substring(posIni, posFin).trim());
        }catch (Exception e){
            throw new LineConverterException(lineNumber, e);
        }
    }
}
