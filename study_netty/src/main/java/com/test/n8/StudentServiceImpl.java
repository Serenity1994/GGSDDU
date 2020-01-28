package com.test.n8;

import com.test.grpc.MyRequest;
import com.test.grpc.MyResponse;
import com.test.grpc.StudentServiceGrpc;
import io.grpc.stub.StreamObserver;

public class StudentServiceImpl  extends StudentServiceGrpc.StudentServiceImplBase {
    @Override
    public void getRealnameById(MyRequest request, StreamObserver<MyResponse> responseObserver) {
        System.out.println("服务器接收到请求:" + request.getId());
        responseObserver.onNext(MyResponse.newBuilder().setRealName("Mike").build());
        responseObserver.onCompleted();
    }
}
