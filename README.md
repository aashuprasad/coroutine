# coroutine
documentation

suspend - suspend functions can be paused and resumed later, allowing for asynchronous programming.

launch - launch is a coroutine builder used to start a new coroutine. The coroutine starts running immediately and runs concurrently with the calling code.

async-await - its a coroutine pattern used for executing multiple coroutines concurrently and waiting for their results.(#async starts a coroutine that immediately returns a Deferred object, #await is used to wait for result of the coroutine).

withContext - its a coroutine builder used to switch to different context for executing a coroutine. it can be used to switch to a different threads or thread pools.

