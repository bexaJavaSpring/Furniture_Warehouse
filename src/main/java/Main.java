import ui.AppUI;
import utils.BaseUtils;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Main {

    static AppUI appUI=new AppUI();

    public static void main(String[] args) {
        LocalDate date1 = LocalDate.now();

        BaseUtils.println("\n\n*************** Project: Printed Product Warehouse *****************");
        BaseUtils.println("--------------- Author: Iroda Abduvosidova  ---------------");
        BaseUtils.println("--------------- Email: iroda_abduvosidova@student.itpu.uz ---------------");
        BaseUtils.println("--------------- Creation date:"+date1+"---------------");
        BaseUtils.println("--------------- Version: version-17 JDK ---------------");
        appUI.run();
    }
}
