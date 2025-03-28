function maxProfit(prices: number[]): number {
    var valorMenor = prices[0];
    var valorMayor = prices[prices.length-1];
    var resta = 0;
    var restaIzq= 0;
    var restaDer = 0;
    var profitF= 0;
    var profit = 0;
    var profitRev = 0;
    var listaDer: number[]=[]
    var listaIzq: number[]=[]

    for (let i=0; i < prices.length; i++){
        valorMenor=Math.min(prices[i], valorMenor);
        restaIzq=prices[i]-valorMenor;
        profit=Math.max(restaIzq, profit);
        listaIzq.push(profit);
    }

    for(let i=prices.length -1; i>=0; i--){
        valorMayor=Math.max(prices[i], valorMayor);
        restaDer=valorMayor-prices[i];
        profitRev=Math.max(restaDer, profitRev);
        listaDer[i]=profitRev;
    }

    for (let i=0; i<prices.length; i++){
        profitF=Math.max(profitF, listaIzq[i]+listaDer[i]);
    }

    return profitF;

};