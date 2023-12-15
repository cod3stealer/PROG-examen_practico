import java.util.Scanner;
class Coche {
    //atributos
    private String marca;
    private float prezo;

    //constructor parametrizado
    public Coche (String marca, float prezo){
        this.marca = marca;
        this.prezo = prezo;
    }
    //Setter
    public void modificarPrezo(float prezo){
        this.prezo = prezo;
    }

    //Getters
    public String getMarca(){
        return marca;
    }
    public float getPrezo(){
        return prezo;
    }
}

class feiraCoches {
    private Coche co;
    // Constructor de esta clase que inicializa un atributo de tipo Coche
    public feiraCoches(String marca, float prezo){
        co = new Coche(marca,prezo);
    }

    //metodo amosar
    public void amosar(){
        System.out.println("Marca: "+co.getMarca());
        System.out.println("Prezo: "+co.getPrezo());
        //Para esto creé los Getters en la clase Coche
    }

    //Metodo bajar prezo
    public float baixarPrezo(float porcentaxeDesconto) {
        // calcula el nuevo precio con el porcentaje dado por parametro
        float nuevoPrezo = co.getPrezo() * (1 - porcentaxeDesconto / 100);
        // Modifica el prezo do coche
        co.modificarPrezo(nuevoPrezo);
        // Devolve o prezo rebaixado
        return nuevoPrezo;
    }
}

public class main {
    public static void main(String[] args) {
        //Declaro o scanner para a recoxida de datos
        Scanner scanner = new Scanner(System.in);

        //atributos
        float descuentoFinalDiaFeria = 15.0f;
        String marca;
        float prezo;
        int control = 1;

        //este bucle encargase de repetir o programa ata que o user presione 0
        while (true) {
            // o seguinte e pedir por pantalla o porcentaxe de desconto que se quere aplicar
            System.out.print("Ingrese el nombre del coche (0 para sair): ");
            marca = scanner.nextLine();
            // se o user ingresa 0 sae do bucle
            if (marca == "0") {
                System.out.println("fin");
                break;
            }
            System.out.println("Es el último día de la feria? (si) (no)");
            if (scanner.nextLine().equalsIgnoreCase("si"))
                control -= 1;


            //pido por pantalla o valor do coche
            System.out.print("Ingrese el precio del coche (0 para sair): ");
            prezo = scanner.nextFloat();
            if (prezo == 0) {
                System.out.println("fin");
                break;
            }
            //paso por parametro o valor do coche o metodo baixarPrezo de feiraCoche
            feiraCoches coches = new feiraCoches(marca, prezo);
            if (control == 1) {
                prezo = coches.baixarPrezo(descuentoFinalDiaFeria);
            }
            //mostro por pantalla os datos do coche
            coches.amosar();

            //pregunto o user se quere pagar ou non o coche
            System.out.print("Ingrese el precio que está dispuesto a pagar (0 para sair): ");
            float precioOfertado = scanner.nextFloat();
            if (precioOfertado == 0) {
                System.out.println("fin");
                break;
            }

            //comparo se o pode permitir ou non
            if (precioOfertado >= prezo) {
                System.out.println("Compra realizada");
            } else {
                System.out.println("debes pagar mais");
            }
        }

        // finalizo o recurso
        scanner.close();
    }
}
