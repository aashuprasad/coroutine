# coroutine
documentation

suspend - suspend functions can be paused and resumed later, allowing for asynchronous programming.

launch - launch is a coroutine builder used to start a new coroutine. The coroutine starts running immediately and runs concurrently with the calling code.

async-await - its a coroutine pattern used for executing multiple coroutines concurrently and waiting for their results.(#async starts a coroutine that immediately returns a Deferred object, await is used to wait for result of the coroutine).

withContext - its a coroutine builder used to switch to different context for executing a coroutine. it can be used to switch to a different threads or thread pools.

dispatchers - they are used to define the execution context for coroutines. there are different dispatchers available, such as Default, IO, Main and Unconfined each with their own charecteristics.

scope, context, job - these are building blocks of coroutines. A CoroutineScope is context for running coroutines.A context provides additional information and setting for coroutine, such as Dispatchers and exception handling. A 'Job' is a handle to a coroutine that can be used to cancel it or wait for its completion.

lifecycleScope, viewModelScope, GlobalScope - These are predefined CoroutineScope instances in Android.
  #lifecycleScope is tied to the lifecycle of an Android component, such as Activity or Fragment.
  #viewModelScope tied to lifecycle of a ViewModel.
  #GlobalScope is a top-level scope that lives as long as the application process.
  
coroutineScope, supervisorScope - these are coroutine builders used to create a new coroutine scope.
  #coroutineScope creates a new scope with a Job abd CoroutineContext, while supervisorScope creates a scope that is independent of its parent scope, allowing for more flexible error handling.
