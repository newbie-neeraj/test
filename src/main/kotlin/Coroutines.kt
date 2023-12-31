import kotlinx.coroutines.*
import kotlin.random.Random


var parameter1 = 100

suspend fun f1(): Int {
    println(" generating 1st value")
    delay(3000)
    val value = Random.nextInt(1000)
    println(" returning 1st value ${value}")
    return  value
}

suspend fun f2(): Int {
    println(" generating 2nd value")
    delay(2000)
    val value = Random.nextInt(10000)
    println(" returning 2nd value ${value}")
    return  value
}



fun main(args: Array<String>) {



    runBlocking {

/*        val myHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
            println(" Exception occurred custom :${throwable.message}")
        }*/

        val job = GlobalScope.async {
            println("Global scope in thread1 : ${coroutineContext}")
            throw IndexOutOfBoundsException()
            /*try{
                throw IndexOutOfBoundsException()
            } catch (e : Exception) {
                println(" inside catch block ")
            }*/
            println("Global scope in thread2 : ${coroutineContext}")
        }
        job.invokeOnCompletion {
            println("job 0 completed")
        }
        println("calling join")
        job.join()
        println("calling await")

        try {
            job.await()
        } catch (e : Exception) {
            println(" exception poutside : ${e.message}")
        }
    }

        /*
            runBlocking {

                val myHandler = CoroutineExceptionHandler{
                        coroutineContext, throwable -> println(" Exception occurred custom :${throwable.message}")
                }

                val job = GlobalScope.launch(myHandler) {
                    println("Global scope in thread : ${coroutineContext}")
                    throw IndexOutOfBoundsException();
                }
                job.invokeOnCompletion {
                    println("job 0 completed")
                }

                job.join()



                */
/*
        val job1  = launch(Dispatchers.Default + myHandler) {
            println("in thread : ${coroutineContext}")
            throw IndexOutOfBoundsException();
        }
        job1.invokeOnCompletion {
            println("job 1 complted")
        }*//*

    }
*/


/*
    runBlocking {
        launch(Dispatchers.Default) {
            println(" Default Dispatcher 1 : ${coroutineContext}")
            withContext(Dispatchers.IO) {
                println(" IO Dispatcher : ${coroutineContext}")
            }
            println(" Deafult Dispatcher 2 : ${coroutineContext}")
        }
    }
*/


    /*
        runBlocking {
            val f1 = async { f1() }
            val f2 = async { f2() }
            println("sum is ${f1.await() + f2.await()}")
        }
    */




    /*    runBlocking {

            launch {
                delay(5000)
                println("hello run blocking")
                delay(3000)
            }

            GlobalScope.launch {
                delay(3000)
                println("hello global")
            }


            coroutineScope {
                launch {
                    delay(8000)
                    println("hello run cou scope")
                    delay(3000)
                }
            }

        }*/



/*
    runBlocking {
*/
/*        launch(Dispatchers.Main){
            println("Main Dispatcher, Thread : ${Thread.currentThread().name}")
        }*//*


        launch(Dispatchers.Unconfined){
            println("Unconfined Dispatcher1, Thread : ${Thread.currentThread().name}")
            delay(1000)
            println("Unconfined Dispatcher2, Thread : ${Thread.currentThread().name}")
        }

        launch(Dispatchers.Default) {
            println("Default Dispatcher, Thread : ${Thread.currentThread().name}")
        }

        launch(Dispatchers.IO) {
            println("IO Dispatcher, Thread : ${Thread.currentThread().name}")
        }

        launch(newSingleThreadContext("Mythread")) {
            println("SingleThreadContext Dispatcher, Thread : ${Thread.currentThread().name}")
        }


    }
*/


/*    runBlocking {
        val job1 = launch {
            println("Job 1 launched")
            delay(3000)
            println("Job 1 finishing")

            val job2 = launch {
                println("Job 2 launched")
                delay(3000)
                println("Job 2 finishing")

                val job3 = launch {
                    println("Job 3 launched")
                    delay(3000)
                    println("Job 3 finishing")
                }

                job3.invokeOnCompletion {
                    println(" job3 is completed")
                }

                delay(2000)
                println(" Cancelling job3 ")
                job3.cancel()
                println("cancelled job3")
            }

            val job4 = launch {
                println("Job 4 launched")
                delay(3000)
                println("Job 4 finishing")
            }

            job2.invokeOnCompletion {
                println(" job2 is completed")
            }

            job4.invokeOnCompletion {
                println(" job4 is completed")
            }

        }

        job1.invokeOnCompletion {
            println("job 1 is completed")
        }


//        delay(2000)
//        println(" Cancelling job")
//        job2.cancel()
//        println("cancelled job")
    }*/







//    println("--------------------")
//    Thread.sleep(3000)
//
//    GlobalScope.launch {
//        hello1()
//        println("01 $parameter1")
//    }
//
//    GlobalScope.launch {
//        hello2()
//        println("02 $parameter1")
//    }
//
//    GlobalScope.launch {
//        hello3()
//        println("03 $parameter1")
//    }





//    runBlocking {
//        launch(CoroutineName("myCouroutine1")) {
//            println(" This iss  run fform ${coroutineContext.get(CoroutineName.Key)}")
//        }
//    }
//
//    println("world")
//    println("dfgdfdggf")


}

fun hello1() {
    println("Hello world 1")
    parameter1++
}

fun hello2() {
    println("Hello world 2")
    parameter1++
}


fun hello3() {
    println("Hello world 3")
    parameter1++
}

