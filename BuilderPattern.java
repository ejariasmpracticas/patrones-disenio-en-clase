import java.util.ArrayList;
import java.util.List;

public class BuilderPattern {

public static void main(String[] args) {
Waiter waiter = new Waiter();

CarritoComprasBuilder combo1Builder = new CarritoComprasCombo1Builder();
CarritoComprasBuilder combo2Builder = new CarritoComprasCombo2Builder();
System.out.println("Combo1: ");
        waiter.setComboBuilder( combo1Builder );
        waiter.constructCombo();

        CarritoCompras carrito = waiter.getCarrito();
        carrito.showItems();
       
        System.out.println("Combo2: ");
       
        waiter.setComboBuilder( combo2Builder );
        waiter.constructCombo();

        CarritoCompras carrito2 = waiter.getCarrito();
        carrito2.showItems();

}

}

interface Item {
public String name();
public float price();
}


abstract class Chaqueta implements Item {



@Override
public abstract float price();
}

abstract class Zapato implements Item {



@Override
public abstract float price();
}

class ChaquetaCuero extends Chaqueta {

  @Override
  public float price() {
     return 100.0f;
  }

  @Override
  public String name() {
     return "Chaqueta Cuero";
  }
}

class ChaquetaJean extends Chaqueta {

  @Override
  public float price() {
     return 50.5f;
  }

  @Override
  public String name() {
     return "Chaqueta Jean";
  }
}

class ZapatoTenis extends Zapato {

  @Override
  public float price() {
     return 30.0f;
  }

  @Override
  public String name() {
     return "Tenis";
  }
}

class ZapatoBotas extends Zapato {

  @Override
  public float price() {
     return 35.0f;
  }

  @Override
  public String name() {
     return "Botas";
  }
}

class CarritoCompras {
  private List<Item> items = new ArrayList<Item>();

  public void addItem(Item item){
     items.add(item);
  }

  public float getCost(){
     float cost = 0.0f;
     
     for (Item item : items) {
        cost += item.price();
     }
     return cost;
  }

  public void showItems(){
 
     for (Item item : items) {
        System.out.print("Item : " + item.name());
        System.out.println(", Price : " + item.price());
     }
  }
}

abstract class CarritoComprasBuilder {



protected CarritoCompras carrito;

   public CarritoCompras getCarritoCompras() {
       return carrito;
   }

   public void createNewCarrito() {
    carrito = new CarritoCompras();
   }
   
   public abstract void buildChaqueta();
   public abstract void buildZapatos();

}

class CarritoComprasCombo1Builder extends CarritoComprasBuilder {


@Override
public void buildChaqueta() {
carrito.addItem(new ChaquetaCuero());

}

@Override
public void buildZapatos() {
carrito.addItem(new ZapatoBotas());

}
}

class CarritoComprasCombo2Builder extends CarritoComprasBuilder {


@Override
public void buildChaqueta() {
carrito.addItem(new ChaquetaJean());

}

@Override
public void buildZapatos() {
carrito.addItem(new ZapatoTenis());

}
}


/* "Director" */
class Waiter {
    private CarritoComprasBuilder comboBuilder;

    public void setComboBuilder(CarritoComprasBuilder pb) {
    comboBuilder = pb;
    }

    public CarritoCompras getCarrito() {
        return comboBuilder.getCarritoCompras();
    }

    public void constructCombo() {
    comboBuilder.createNewCarrito();
    comboBuilder.buildChaqueta();
    comboBuilder.buildZapatos();

    }
}


