package com.test.pb1;

import com.google.protobuf.InvalidProtocolBufferException;

public class ProtoBufTest {
    public static void main(String[] args) throws InvalidProtocolBufferException {
        DataInfo.Student student = DataInfo.Student.newBuilder().setName("mike").setAge(20).setAddress("hangzhou").build();
        byte[] toByteArray = student.toByteArray();
        DataInfo.Student student1 = DataInfo.Student.parseFrom(toByteArray);
        System.out.println(student1.getName());
        System.out.println(student1.getAge());
        System.out.println(student1.getAddress());
    }
}
