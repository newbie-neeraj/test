import kotlinx.coroutines.*
import kotlin.random.Random


fun hello () {
    println("Hello World...")
}


suspend fun fun1():Int {
    println("Generating 1st value")
    delay(3000)
    val value =  Random.nextInt(1000)
    println(" returning 1st value $value")
    return  value
}


suspend fun fun2():Int {
    println("Generating 2nd value")
    delay(3000)
    val value =  Random.nextInt(10000)
    println(" returning 2nd value $value")
    return  value
}


fun main(args: Array<String>) {

// 1
    /*
    runBlocking {
        val job1 = launch(CoroutineName("myCoroutine")) {
            println("Called from ${coroutineContext[CoroutineName.Key]}")
            println("Called from ${coroutineContext.get(CoroutineName.Key)}")
            hello()
        }
    }*/



// 2
    /*
    val job2 = GlobalScope.launch {
        delay(3000)
        println("hello world")
    }*/



// 3
    /*
    val job6 = runBlocking {
        val job3 = launch {
            println("Job 3 launched")
            delay(5000)
            println("hello run blocking")
            delay(3000)

            val job7 =  launch {
                println("Job 7 launched")
                delay(2000)
                println("Job 7 completing")

                val job8 = launch {
                    println("Job 8 launched")
                    delay(3000)
                    println("Job 8 finishing")
                }

                job8.invokeOnCompletion {
                    println(" job8 is completed")
                }

                delay(2000)
                println(" Cancelling job8 ")
                job8.cancel()
                println("cancelled job8")
            }

            val job9 = launch {
                println("Job 9 launched")
                delay(3000)
                println("Job 9 finishing")
            }

            job9.invokeOnCompletion {
                println(" job9 is completed")
            }

            job7.invokeOnCompletion {
                println(" job7 is completed")
            }

        }

        job3.invokeOnCompletion {
            println(" job3 is completed")
        }


        val job4 = GlobalScope.launch {
            println("Job 4 launched")
            delay(3000)
            println("hello global")
        }


        val job5 = coroutineScope {
            launch {
                println("Job 5 launched")
                delay(1000)
                println("hello run cou scope")
            }
        }

    }
    println("bye bye")*/



//4
    /*
    runBlocking {
        //launch(Dispatchers.Main) {
        //    println("Main Dispatcher : Thread: ${Thread.currentThread().name}")
        //}

        launch(Dispatchers.Default) {
            println("Default Dispatcher : Thread: ${Thread.currentThread().name}")
        }

        launch(Dispatchers.IO) {
            println("IO Dispatcher : Thread: ${Thread.currentThread().name}")
        }

        launch(newSingleThreadContext("My Thread")) {
            println("Single thread Context Dispatcher :  : Thread: ${Thread.currentThread().name}")
        }

        launch(Dispatchers.Unconfined) {
            println("Unconfined Dispatcher :  : Thread: ${Thread.currentThread().name}")
            delay(2000)
            println("Unconfined Dispatcher :  : Thread: ${Thread.currentThread().name}")
        }
    }*/



//5
    /*
    runBlocking {
        val v1 = async {fun1()}
        val v2 = async {fun2()}
        val v3 = v1.await() + v2.await()
        println("Sum is $v3")
    }*/



//6
    /*
    runBlocking {
        launch(Dispatchers.Default) {
            println("Default Dispatcher : $coroutineContext")
            withContext(Dispatchers.IO) {
                println("IO Dispatcher : $coroutineContext")
            }
            println("Default Dispatcher : $coroutineContext")
        }
    }*/








//7
    /*
    var myHandler = CoroutineExceptionHandler{
        coroutineContext, throwable ->   println(" Exception occurred custom message: ${throwable.message}")
    }

    //    runBlocking {
    //        var job11 = launch(myHandler) {
    //            throw IndexOutOfBoundsException();
    //        }
    //        delay(3000)
    //        println("job11...")
    //        job11.invokeOnCompletion {
    //            println("job 11 completed")
    //        }
    //    }

    //    runBlocking {
    //        var job12 = launch(Dispatchers.Default + myHandler) {
    //            throw IndexOutOfBoundsException();
    //        }
    //        delay(3000)
    //        println("job12...")
    //        job12.invokeOnCompletion {
    //            println("job 12 completed")
    //        }
    //    }

    //    runBlocking {
    //        var job13 = launch(Dispatchers.Default + myHandler) {
    //            throw IndexOutOfBoundsException();
    //        }
    //        delay(3000)
    //        println("job13...")
    //        job13.invokeOnCompletion {
    //            println("job 13 completed")
    //        }
    //        job13.join()
    //    }

    runBlocking {
        var job14 = GlobalScope.launch(myHandler){
            throw IndexOutOfBoundsException();
        }
        delay(3000)
        println("job14...")
        job14.invokeOnCompletion {
            println("job 14 completed")
        }
    }*/





//8
    /*
    val myHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        println(" Exception occurred custom :${throwable.message}")
    }

    runBlocking {

    //       val v1 = GlobalScope.async {
    //           println("Global scope in thread1 : $coroutineContext")
    //           throw IndexOutOfBoundsException()
    //       }
    //       v1.invokeOnCompletion {
    //           println("v1 fetched")
    //       }


    //        val v2 = GlobalScope.async {
    //            println("Global scope in thread1 : $coroutineContext")
    //            throw IndexOutOfBoundsException()
    //        }
    //        v2.invokeOnCompletion {
    //            println("v2 fetched")
    //        }
    //        println("calling join")
    //        v2.join()


    //        val v3 = GlobalScope.async {
    //            println("Global scope in thread1 : $coroutineContext")
    //            throw IndexOutOfBoundsException()
    //        }
    //        v3.invokeOnCompletion {
    //            println("v3 fetched")
    //        }
    //        println("calling await")
    //        v3.await()


    //        val v4 = GlobalScope.async {
    //            println("Global scope in thread1 : $coroutineContext")
    //            throw IndexOutOfBoundsException()
    //        }
    //        v4.invokeOnCompletion {
    //            println("v4 fetched")
    //        }
    //        println("calling await")
    //        try {
    //            v4.await()
    //        } catch (exp : Exception) {
    //            println(" exception outside : ${exp.message}")
    //        }


    //        val v5 = GlobalScope.async {
    //            println("Global scope in thread1 : $coroutineContext")
    //            try {
    //                throw IndexOutOfBoundsException()
    //            } catch (exp : Exception) {
    //                println(" exception outside : ${exp.message}")
    //            }
    //        }
    //        v5.invokeOnCompletion {
    //            println("v5 fetched")
    //        }
    //        println("calling await")
    //        v5.await()
    //        println("await called")

    }*/

    

//9



    
}

