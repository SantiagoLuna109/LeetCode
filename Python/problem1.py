class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        valorMenor= prices[0]
        valorMayor= prices[len(prices)-1]
        resta=0
        restaIzq=0
        restaDer=0
        profitF=0
        profit=0
        profitRev=0
        listaDer=[]
        listaIzq=[]

        for i, price in enumerate(prices):
            valorMenor=min(prices[i], valorMenor)
            restaIzq=prices[i]-valorMenor
            profit=max(restaIzq, profit)
            listaIzq.append(profit)

        for i in range(len(prices)-1, -1, -1):
            valorMayor=max(prices[i], valorMayor)
            restaDer=valorMayor-prices[i]
            profitRev=max(restaDer, profitRev)
            listaDer.insert(0, profitRev)

        for i in range(0, len(prices), 1):
            profitF=max(profitF, listaDer[i]+listaIzq[i])
        
        return profitF