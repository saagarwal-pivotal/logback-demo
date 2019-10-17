# Sample spring boot demo project for demonstrating the async logging.

Below are async console appender and async file appender configeration

Please refer to logback.xml for complete usage

```
	<appender name="ASYNC_CONSOLE"
		class="ch.qos.logback.classic.AsyncAppender">
		<discardingThreshold>0</discardingThreshold> <!-- default 20, means drop lower event when has 20% capacity remaining -->
		<appender-ref ref="CONSOLE" />
		<queueSize>50000</queueSize> <!-- default 256 -->
		<includeCallerData>false</includeCallerData><!-- default false -->
		<neverBlock>true</neverBlock><!-- default false, set to true to cause the 
			Appender not block the application and just drop the messages -->
	</appender>

	<appender name="ASYNC_FILE"
		class="ch.qos.logback.classic.AsyncAppender">
		<discardingThreshold>0</discardingThreshold> <!-- default 20, means drop lower event when has 20% capacity remaining -->
		<appender-ref ref="FILE" />
		<queueSize>50000</queueSize> <!-- default 256 -->
		<includeCallerData>false</includeCallerData><!-- default false -->
		<neverBlock>true</neverBlock><!-- default false, set to true to cause
			the Appender not block the application and just drop the messages -->
	</appender>
```

## Below are some of parameters that can be tuned 

# Queue Size		
The maximum capacity of the blocking queue. By default, queueSize is set to 256.
# Discarding Threshold	
	By default, when the blocking queue has 20% capacity remaining, it will drop events of level TRACE, DEBUG and INFO, keeping only events of level WARN and ERROR. To keep all events, set discardingThreshold to 0.
# IncludeCallerData	
	Extracting caller data can be rather expensive. To improve performance, by default, caller data associated with an event is not extracted when the event added to the event queue. By default, only "cheap" data like the thread name and the MDC are copied. You can direct this appender to include caller data by setting the includeCallerData property to true.
# Max Flush Time	
	Depending on the queue depth and latency to the referenced appender, the AsyncAppender may take an unacceptable amount of time to fully flush the queue. When the LoggerContext is stopped, the AsyncAppender stop method waits up to this timeout for the worker thread to complete. Use maxFlushTime to specify a maximum queue flush timeout in milliseconds. Events that cannot be processed within this window are discarded. Semantics of this value are identical to that of Thread.join(long).
neverBlock	boolean	If false (the default) the appender will block on appending to a full queue rather than losing the message. Set to true and the appender will just drop the message and will not block your application.

# How to run this app
```

```