package practica.clase2.tm.ejercicio5;

import java.text.*;
import java.util.*;

public class Fecha {
    private Calendar fecha;
    private Locale locale;
    private SimpleDateFormat formatOfDate;

    public Fecha() {
        this.fecha = GregorianCalendar.getInstance();
        this.locale = Locale.getDefault();
        this.formatOfDate = new SimpleDateFormat("dd-MM-yyyy");
        this.formatOfDate.setLenient(false);
    }

    public Fecha(String fecha) {
        this.fecha = GregorianCalendar.getInstance();
        this.locale = Locale.getDefault();
        this.formatOfDate = new SimpleDateFormat("dd-MM-yyyy");
        this.formatOfDate.setLenient(false);
        try {
            this.fecha.setTime(formatOfDate.parse(fecha));
        } catch (ParseException e) {
            this.fecha = GregorianCalendar.getInstance();

        }
    }

    public Calendar sumar() {
        this.fecha.add(Calendar.DAY_OF_MONTH, 1);
        return this.fecha;
    }

    public Boolean validar(String fecha) {
        try {
            formatOfDate.parse(fecha);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public Calendar getFecha() {
        return this.fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public Locale getLocale() {
        return this.locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public SimpleDateFormat getFormatOfDate() {
        return this.formatOfDate;
    }

    public void setFormatOfDate(SimpleDateFormat formatOfDate) {
        this.formatOfDate = formatOfDate;
    }

    @Override
    public String toString() {
        return "Fecha{" +
                "fecha=" + fecha +
                ", locale=" + locale +
                ", formatOfDate=" + formatOfDate +
                '}';
    }
}
