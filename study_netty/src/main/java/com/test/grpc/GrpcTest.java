// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Student.proto

package com.test.grpc;

public final class GrpcTest {
  private GrpcTest() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_test_grpc_MyRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_test_grpc_MyRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_test_grpc_MyResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_test_grpc_MyResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\rStudent.proto\022\rcom.test.grpc\"\027\n\tMyRequ" +
      "est\022\n\n\002id\030\001 \001(\005\"\036\n\nMyResponse\022\020\n\010realNam" +
      "e\030\002 \001(\t2Z\n\016StudentService\022H\n\017GetRealname" +
      "ById\022\030.com.test.grpc.MyRequest\032\031.com.tes" +
      "t.grpc.MyResponse\"\000B\033\n\rcom.test.grpcB\010Gr" +
      "pcTestP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_com_test_grpc_MyRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_test_grpc_MyRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_test_grpc_MyRequest_descriptor,
        new String[] { "Id", });
    internal_static_com_test_grpc_MyResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_test_grpc_MyResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_test_grpc_MyResponse_descriptor,
        new String[] { "RealName", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
