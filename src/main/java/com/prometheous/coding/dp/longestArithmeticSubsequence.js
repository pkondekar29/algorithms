solve = function (nums) {
    let max = 1
    for (var i = 0; i < nums.length; i++) {
        for (var j = 0; j < nums.length; j++) {
            let max_curr = dfs(nums, i, -1, nums[j] - nums[i])
            if (max_curr > max) max = max_curr
        }
    }
    return max;
}

dfs = function (nums, currI, prevI, diff, memo = {}) {
    if (prevI != -1)
        if (nums[currI] - nums[prevI] != diff)
            return 0

    let key = prevI + ":" + currI + ":" + diff
    if (memo[key] != null) return memo[key]

    let max = 1
    for (let k = currI + 1; k < nums.length; k++) {
        let max_c = dfs(nums, k, currI, diff, memo) + 1
        if (max_c > max) max = max_c
    }
    memo[key] = max
    return max
}

console.log(solve([100, 10, 8, 300, 6, 1, 4, 2]))