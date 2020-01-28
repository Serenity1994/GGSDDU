package com.test.n8;

import com.test.grpc.MyRequest;
import com.test.grpc.MyResponse;
import com.test.grpc.StudentServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 8899)
                .usePlaintext().build();
        StudentServiceGrpc.StudentServiceBlockingStub blockingStub = StudentServiceGrpc.newBlockingStub(managedChannel);
        MyResponse myResponse = blockingStub.getRealnameById(MyRequest.newBuilder().setId(1).build());
        System.out.println(myResponse.getRealName());
    }
}
