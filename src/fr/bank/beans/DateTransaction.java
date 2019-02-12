package fr.bank.beans;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTransaction {

    public String getDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return simpleDateFormat.format(new Date());
    }
}
