package blinenterprise;

public class ProbabilisticsCalculator {

    public ProbabilisticsCalculator() {
    }
    
    private int abs(int x){     // Wartosc bezwzgledna
        if (x<0) return -x;
        else return x;
    }
    
    private double power(double x, int n){  //Potega
        double result = 1.0;
        for (int i=0; i<abs(n); i++){
            result = result * x;
        }
        if (n<0) result = 1/result;
        return result;
    }
    
    private int Factorial(int x){   //  Silnia
        int result = 1;
        for (int i=1; i<=x; i++){
            result *= i;
        }
        return result;
    }
    
    private double Binominal(int n, int k){     // Symbol Newton (n nad k)
        return (double)Factorial(n) / ((double)Factorial(k)* (double)Factorial(n-k));
    }
    
    public double ExtendedBernoulli(int n, int k, int card_amount, int deck_size){      // Funkcja liczy prawdopodobienstwa CO NAJMNIEJ k sukcesow w n probach
        double result = 0.0;
        for (int i=1; i<= k; i++){
            result += Bernoulli(n, k, card_amount, deck_size);
        }
        return result;
    }
                    
    public double Bernoulli(int n, int k, int card_amount, int deck_size){              // Schemat Bernoulliego liczy prawdopodobienstwo k sukcesow w n probach
        double p = (double)card_amount / (double) deck_size;
        double q = 1.0 - p;
        double probs = Binominal(n, k) * power(p, k) * power(q, n-k);
        return probs;
    }
}
