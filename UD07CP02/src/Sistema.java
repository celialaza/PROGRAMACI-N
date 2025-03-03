import java.util.Scanner;

public class Sistema {
    public static void main(String[] args) {
        // Definimos la constante de tamaño
        final int tamanio= 10;

        // Creamos el array de objetos de la clase Mundo con el tamaño definido
        Mundo[] planetas = new Mundo[tamanio];

        // Rellenamos el array con nuevos objetos de la clase Mundo
        for (int i = 0; i < tamanio; i++) {
            planetas[i] = new Mundo();
        }
        double diametro=0;
        boolean datoValido=false;
        Scanner sc=new Scanner(System.in);

        do{
            try{
            //Especificar que "tamanio" y "planetas.length viene a referirse a lo mismo
            for (int i=0; i< planetas.length; i++){
                System.out.println("Diámetro del planeta"+i+": ");
                diametro =Double.parseDouble(sc.nextLine());
                if (diametro < 0) {
                    throw new ValorNegativoException();
                }
                planetas[i].setDiametro(diametro);
                datoValido=true;
            }
            }
            catch(NumberFormatException nfe){
                System.out.println("El valor del diámetro debe ser numérico");
                System.out.println("Defínelo de nuevo, por favor");
                datoValido=false;


                }
            catch(ValorNegativoException vne){
                System.out.println("Introduce de nuevo el dato");
                datoValido=false;
            }
        }while(!datoValido);


        //inicializar array a 0
        int i=0;

        while(i<planetas.length){

        try{
            if (planetas[i].getDiametro() <20){
                throw new DiametroInferiorException("El diámetro del planeta "+i+" es inferior a 20 km.");
            }
            if(planetas[i].getDiametro()>100){
            throw new DiametroSuperiorException("El diámetro del planeta "+i+" es superior a 100km");
            }

        }
        catch(DiametroInferiorException die){
            System.out.println(die.getMessage());

        }
        catch(DiametroSuperiorException dse){
            System.out.println(dse.getMessage());

        }
        catch(Exception e){
            System.out.println("Ha ocurrido una excepción");

        }
        i++;
        }

        System.out.println("El proceso ha terminado");


        }


    }

