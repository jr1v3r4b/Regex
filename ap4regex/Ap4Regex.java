package ap4regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author harri
 */
public class Ap4Regex {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opcion = 0;
        String menu = "***MAIN MENU REGULAR EXPRESSION***\n"
                + "1- Placa de vechiculo\n"
                + "2- Número Fijo\n"
                + "3- Número de Ceular\n"
                + "4- Direcciones\n"
                + "5- Email\n"
                + "6- Fecha\n"
                + "7- Formato 24 horas\n"
                + "8- Cédula\n"
                + "9- Contraseña\n"
                + "0- Salir";
        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
                switch (opcion) {
                    case 1:
                        placavechiculo();
                        
                        break;

                    case 2:
                        numFijos();

                        break;
                    case 3:
                        numCelulares();
                        break;
                        
                    case 4:
                        direcciones();
                        break;

                    case 5:
                        email();
                        break;

                    case 6:
                        date();
                        break;

                    case 7:
                        hour24();
                        break;

                    case 8:
                        cedula();
                        break;

                    case 9:
                        password();
                        break;
                        
                    case 0:
                        System.exit(0);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Opción no válida");
            }
        } while (opcion != 0);

    }

    public static void placavechiculo() {
        String placa, patron;

        placa = "SJY-01F"; //Caso 1
        patron = "^[A-Z]{3}-[0-9]{2}([A-G])?$";

        Pattern p = Pattern.compile(patron, Pattern.CASE_INSENSITIVE);
        Matcher mt = p.matcher(placa);

        if (mt.find() == true) {
            System.out.println("Las placas son validas");
        } else {
            System.out.println("Las placas no son validas");
        }
    }

    public static void numFijos() {
        String tel, patron;

        tel = "6044444141";
        patron = "^\\\\+57604[23456]/d{6}$/ ";

        Pattern p = Pattern.compile(patron, Pattern.CASE_INSENSITIVE);
        Matcher mt = p.matcher(tel);

        if (mt.find() == true) {
            System.out.println("el telefono es valido");
        } else {
            System.out.println("el telefono no es valido");
        }
    }

    public static void numCelulares() {
        String cel, patron;

        cel = "3057644637";
        patron = "(\\+57|3|1025)?[ -](6|7)[ -]([0-9][ -]*){8}"; // "^3[01235]/d{8}$/"

        Pattern p = Pattern.compile(patron, Pattern.CASE_INSENSITIVE);
        Matcher mt = p.matcher(cel);

        if (mt.find() == true) {
            System.out.println("el celular es valido");
        } else {
            System.out.println("el celular no es valido");
        }
    }

    public static void direcciones() {
        String dir, patron;

        dir = "Calle 103 # 42B BIS - 45"; //Caso 1
        patron = "^(Autopista|Avenida|Avenida Calle|Avenida Carrera|Avenida|Carrera|Calle|Carrera|Circunvalar|Diagonal|Kilometro|Transversal|AUTOP|AV|AC|AK|CL|KR|CCV|DG|KM|TV)(\\s)?([a-zA-Z]{0,15}|[0-9]{1,3})(\\s)?[a-zA-Z]?(\\s)?(bis)?(\\s)?(Este|Norte|Occidente|Oeste|Sur)?(\\s)?(#(\\s)?[0-9]{1,2}(\\s)?[a-zA-Z]?(\\s)?(bis)?(\\s)?(Este|Norte|Occidente|Oeste|Sur)?(\\s)?(-)?(\\s)?[0-9]{1,3}(\\s)?(Este|Norte|Occidente|Oeste|Sur)?)?((\\s)?(Agrupación|Altillo|Apartamento|Apartamento Sótano|Barrio|Bloque|Bodega|Cabecera Municipal|Callejón|Camino|Carretera|Casa|Caserio|Célula|Centro|Centro Comercial|Centro Urbano|Circular|Condominio|Conjunto|Consultorio|Corregimiento|Deposito|Deposito |Sótano|Edificio|Entrada|Esquina|Etapa|Finca|Garaje|Garaje Sótano|Grada|Inferior|Inspección de Policia|Interior|Kilometro|Local|Local Mezzanine|Local Sótano|Lote|Manzana|Manzanita|Mejora|Mezzanine|Módulo|Municipio|Núcleo|Oficina|Oficina Sótano|Parcela|Parcelación|Pasaje|Penthouse|Piso|Porteria|Predio|Principal|Puente|Quebrada|Salon|Sector|Semisótano|Suite|Supermanzana|Terraza|Torre|Troncal|Unidad|Urbanización|Vereda|Via|Zona|AGN|AL|APTO|AS|BR|BL|BG|CM|CLJ|CN|CT|CA|CAS|CEL|CE|CECO|CEUR|CIR|CDM|CONJ|CS|CO|DP|DS|ED|EN|ESQ|ET|FCA|GJ|GS|GR|INF|IP|IN|KM|LC|LM|LS|LT|MZ|MZTA|MJ|MN|MD|MUN|NCO|OF|OS|PA|PCN|PSJ|PH|PI|PT|PD|PPAL|PN|QDA|SA|SEC|SS|SU|SMZ|TZ|TO|TRL|UN|URB|VDA|VIA|ZN)?(\\s)?[1-9][0-9]{0,3})*$";

        Pattern p = Pattern.compile(patron, Pattern.CASE_INSENSITIVE);
        Matcher mt = p.matcher(dir);

        if (mt.find() == true) {
            System.out.println("La direccion es valido");
        } else {
            System.out.println("La direccion no es valido");
        }
    }

    public static void email() {
        String correo, patron;

        correo = "jrivea_9876@elpoli.edu.co"; //Caso 1
        patron = "[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)@[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)[.][a-zA-Z]{2,5} "; //^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$

        Pattern p = Pattern.compile(patron, Pattern.CASE_INSENSITIVE);
        Matcher mt = p.matcher(correo);

        if (mt.find() == true) {
            System.out.println("el correo es valido");
        } else {
            System.out.println("el correo no es valido");
        }
    }

    public static void date() {
        String fecha, patron;

        fecha = "12-10-2023";
        patron = "^(0[1-9]|[12][0-9]|3[01])\\-(0[1-9]|1[012])\\-\\d{4}\\$";

        Pattern p = Pattern.compile(patron, Pattern.CASE_INSENSITIVE);
        Matcher mt = p.matcher(fecha);

        if (mt.find() == true) {
            System.out.println("La fecha es valido");
        } else {
            System.out.println("La fecha no es valido");
        }
    }

    public static void hour24() {
        String hora, patron;

        hora = "10:22:00";
        patron = "^(?:([01]?\\d|2[0-3]):([0-5]?\\d):)?([0-5]?\\d)$";

        Pattern p = Pattern.compile(patron, Pattern.CASE_INSENSITIVE);
        Matcher mt = p.matcher(hora);

        if (mt.find() == true) {
            System.out.println("La hora es valido");
        } else {
            System.out.println("La hora no es valido");
        }
    }

    public static void cedula() {
        String ced, patron;

        ced = "1035436353";
        patron = "/^[12]\\d{1,8}$/i";

        Pattern p = Pattern.compile(patron, Pattern.CASE_INSENSITIVE);
        Matcher mt = p.matcher(ced);

        if (mt.find() == true) {
            System.out.println("La cedula es valido");
        } else {
            System.out.println("La cedula no es valido");
        }
    }

    public static void password() {
        String contra, patron;

        contra = "178928Hi*";
        patron = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$";

        Pattern p = Pattern.compile(patron, Pattern.CASE_INSENSITIVE);
        Matcher mt = p.matcher(contra);

        if (mt.find() == true) {
            System.out.println("La contraseña es segura");
        } else {
            System.out.println("La contraseña no es segura");
        }
    }
}