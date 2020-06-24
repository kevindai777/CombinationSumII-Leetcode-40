//Objective is to do the same thing as 'Combination Sum' except to only use each
//element only once.

let candidates = [10,1,2,7,6,1,5]
let target = 8


//O() solution

let temp = []
let sum = 0
let index = 0
let result = []

//Sort the elements so we avoid repeats
candidates.sort((a,b) => {
    return a - b
})

backtrack (temp, sum, index)

function backtrack(temp, sum, index) {
    if (sum > target) {
        return
    }

    //Make a copy of the array into the result
    if (sum == target) {
        result.push([...temp])
        return
    }

    for (let i = index; i < candidates.length; i++) {
        if (i !== index && candidates[i] == candidates[i - 1]) {
            continue
        }

        //push the value in then pop it out to make sure it's only used once
        temp.push(candidates[i])
        backtrack(temp, sum + candidates[i], i + 1)
        temp.pop()
    }
}

console.log(result)