
package blinenterprise;


public class CardNotFoundException extends Throwable{       // Wyjatek wyrzucany, gdy podana karta nie zostala znaleziona
    public CardNotFoundException(){
        super();
    }
    public CardNotFoundException(String message){
        super(message);
    }
    public CardNotFoundException(Throwable reason){
        super(reason);
    }
}
