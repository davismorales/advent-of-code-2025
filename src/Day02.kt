fun main() {
    val sequences = "990244-1009337,5518069-5608946,34273134-34397466,3636295061-3636388848,8613701-8663602,573252-688417,472288-533253,960590-988421,7373678538-7373794411,178-266,63577667-63679502,70-132,487-1146,666631751-666711926,5896-10827,30288-52204,21847924-21889141,69684057-69706531,97142181-97271487,538561-555085,286637-467444,93452333-93519874,69247-119122,8955190262-8955353747,883317-948391,8282803943-8282844514,214125-236989,2518-4693,586540593-586645823,137643-211684,33-47,16210-28409,748488-837584,1381-2281,1-19".split(",")

    /**
     * Day 2 Part 1
     */
    var sum = 0.toLong()
    sequences.forEach { seq ->
        val range = seq.split("-")
        var length = range[1].length
        if(length % 2 != 0) length -= 1
        for(i in range[0].toLong()..range[1].toLong()) {
            if(i.toString().length == length) {
                val chunkLength = length/2
                val firstHalf = i.toString().substring(0, chunkLength)
                val secondHalf = i.toString().substring(chunkLength)
                if(firstHalf == secondHalf) {
                    sum += i
                }
            }
        }
    }
    println("Part 1 Sum: $sum")

    /**
     * Day 2 Part 2
     */
    val ids = mutableListOf<Long>()
    sequences.forEach { seq ->
        val range = seq.split("-")
        for(num in range[0].toLong()..range[1].toLong()) {
            for (chunk in 1..range[1].length) {
                if(num.toString().length % chunk == 0) {
                    val chunked = num.toString().chunked(chunk)
                    if(chunked.size > 1 && chunked.all { chunk -> chunk == chunked[0] }) {
                        if(!ids.contains(num)) {
                            ids.add(num)
                        }
                        break
                    }
                }
            }
        }
    }
    println("Part 2 Sum: ${ids.sum()}")
}