package com.aksops.function;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import com.microsoft.azure.functions.annotation.QueueTrigger;

import java.util.Optional;

public class Function {
    @FunctionName("HttpExample")
    public void run(
            @QueueTrigger(
                name = "req",queueName = "local",connection = "AzureWebJobsStorage")
                String result,
            final ExecutionContext context) {
        context.getLogger().info("Java HTTP trigger processed a request.");
        System.out.println(result);
    }
}
