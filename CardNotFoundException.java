
package BlinEnterprise;


public class CardNotFoundException extends Throwable{
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
