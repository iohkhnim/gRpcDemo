package com.khoi.customer.config;

import com.khoi.orderproto.OrderServiceGrpc;
import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.NegotiationType;
import io.grpc.netty.NettyChannelBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Configuration
public class ApplicationConfig {

  @Value("${orderServiceEndpoint}")
  private String orderServiceEndpoint;

  @Value("${orderServerKeyPath}")
  private String orderServerKeyPath;
  /**
   * Create a channel to communicate with gRPC server
   *
   * @return order Channel for gRPC purpose
   */
  @Bean(name = "orderChannel")
  Channel orderChannel() throws Exception {
    return NettyChannelBuilder.forTarget(orderServiceEndpoint)
        .negotiationType(NegotiationType.TLS)
        .sslContext(GrpcSslContexts.forClient().trustManager(new File(orderServerKeyPath)).build())
        .build();
    // return ManagedChannelBuilder.forTarget(orderServiceEndpoint).usePlaintext().build();
  }

  /**
   * Create a gRPC service instance to use provided methods
   *
   * @param orderChannel Channel for order gRPC server
   * @return order service for gRPC server
   */
  @Bean(name = "orderService")
  @Qualifier("orderChannel")
  OrderServiceGrpc.OrderServiceBlockingStub orderService(Channel orderChannel) {
    return OrderServiceGrpc.newBlockingStub(orderChannel);
  }
}
