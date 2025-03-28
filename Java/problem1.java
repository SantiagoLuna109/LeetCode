class Solution {
    public int maxProfit(int[] prices) {
        int valorMenor = prices[0];
        int valorMayor = prices[prices.length-1];
        int resta = 0;
        int restaIzq=0;
        int restaDer=0;
        int profitF=0;
        int profit=0;
        int profitRev=0;
        List <Integer> listaDer = new ArrayList<>();
        List <Integer> listaIzq = new ArrayList<>();

        

        //izq a der
        for (int i=0; i<prices.length; i++){
            //restaIzq=prices[i]-valorMenor;
            valorMenor=Math.min(prices[i], valorMenor);
            
            //System.out.println(restaIzq);
            
            restaIzq=prices[i]-valorMenor;
            profit=Math.max(restaIzq, profit);
            listaIzq.add(profit);
        }
        
        //der a Izq
        for (int i=prices.length-1; i>=0; i--){
            valorMayor=Math.max(prices[i], valorMayor);
                        
            restaDer=valorMayor-prices[i];
            profitRev=Math.max(restaDer, profitRev);
            listaDer.add(0,profitRev);
        }

        for(int i=0; i<prices.length; i++){
            profitF =Math.max(profitF, listaDer.get(i)+listaIzq.get(i));
        }
        

        return(profitF);
        
    }
}