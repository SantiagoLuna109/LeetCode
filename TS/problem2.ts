function minPatches(nums: number[], n: number): number {
    let patches = 0;
    let i = 0;
    for(let acum = 1;acum<=n;){
        if (i < nums.length && nums[i] <= acum) {
            acum += nums[i];//Aqui ya no hay comentarios pk principalmente es copy paste del de java
            i ++;
        }else{
            patches ++;
            acum += acum;
        }
    }
    return patches;
};