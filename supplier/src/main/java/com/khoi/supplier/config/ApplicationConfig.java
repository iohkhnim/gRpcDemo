package com.khoi.supplier.config;

import com.khoi.productproto.ProductServiceGrpc;
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

  @Value("${productServiceEndpoint}")
  private String productServiceEndpoint;
  @Value("${productServerKeyPath}")
  private String productServerKeyPath;

  @Bean(name = "productChannel")
  Channel productChannel() throws Exception {
    return NettyChannelBuilder.forTarget(productServiceEndpoint)
            .negotiationType(NegotiationType.TLS)
            .sslContext(
                    GrpcSslContexts.forClient().trustManager(new File(productServerKeyPath)).build())
            .build();
    // return ManagedChannelBuilder.forTarget(productServiceEndpoint).usePlaintext().build();
  }

  @Bean(name = "productService")
  @Qualifier("productChannel")
  ProductServiceGrpc.ProductServiceBlockingStub priceService(Channel productChannel) {
    return ProductServiceGrpc.newBlockingStub(productChannel);
  }
}
