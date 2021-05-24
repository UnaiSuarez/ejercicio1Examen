import java.util.*;

public class CajaRegistradora {

    Scanner scanner = new Scanner(System.in);
    public void caja(){
        int coste = costeAleatorio();
        System.out.println("El coste es: "+coste+", ¿Cuanto desea entregar?");
        int entregar = 0;
        while (true){
            System.out.print("Dinero a entregar: ");
             entregar= Integer.parseInt(scanner.nextLine());
            if (entregar < coste || entregar > 500){
                System.out.println("El dinero que has entregado no es posible");
            }else {
                break;
            }
        }
        int resultado = entregar - coste;
        HashMap<Integer,List<Integer>> devolver = sacarBilletes(resultado);
        System.out.println("Coste de:"+coste+", se ha pagado con: "+entregar);
            System.out.println("Debe devolver: "+devolver.get(50).size()+" billetes de 50€");
            System.out.println("Debe devolver: "+devolver.get(20).size()+" billetes de 20");
            System.out.println("Debe devolver: "+devolver.get(10).size()+" billetes de 10€");
            System.out.println("Debe devolver: "+devolver.get(5).size()+" billetes de 5€");
            System.out.println("Debe devolver: "+devolver.get(2).size()+" monedas de 2€");
            System.out.println("Debe devolver: "+devolver.get(1).size()+" monedas de 1€");

    }

    private int costeAleatorio(){
        Random random = new Random();
        int numero = random.nextInt(500);
        return numero;
    }

    private HashMap<Integer,List<Integer>> sacarBilletes(Integer respuesta){
        HashMap<Integer,List<Integer>> billetes = new HashMap<Integer, List<Integer>>();
        billetes.put(50,new ArrayList<>());
        billetes.put(20,new ArrayList<>());
        billetes.put(10,new ArrayList<>());
        billetes.put(5,new ArrayList<>());
        billetes.put(2,new ArrayList<>());
        billetes.put(1,new ArrayList<>());
        while (respuesta > 0){
            if (respuesta >= 50){
                billetes.get(50).add(+1);
                respuesta = respuesta - 50;
            }
            else if (respuesta >= 20){
                billetes.get(20).add(+1);
                respuesta = respuesta - 20;
            }
            else if  (respuesta >= 10){
                billetes.get(10).add(+1);
                respuesta = respuesta - 10;
            }
            else if  (respuesta >= 5){
                billetes.get(5).add(+1);
                respuesta = respuesta - 5;
            }
            else if  (respuesta >= 2){
                billetes.get(2).add(+1);
                respuesta = respuesta - 2;
            }
            else if  (respuesta >= 1){
                billetes.get(1).add(+1);
                respuesta = respuesta - 1;
            }
        }
        return billetes;
    }
}
