// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: PingPong.proto

package org.pablo.codec;

public final class PingPongPayload {
  private PingPongPayload() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface PingPongMessageOrBuilder
      extends com.google.protobuf.MessageOrBuilder {

    // required string ping = 1;
    /**
     * <code>required string ping = 1;</code>
     */
    boolean hasPing();
    /**
     * <code>required string ping = 1;</code>
     */
    java.lang.String getPing();
    /**
     * <code>required string ping = 1;</code>
     */
    com.google.protobuf.ByteString
        getPingBytes();

    // required string pong = 2;
    /**
     * <code>required string pong = 2;</code>
     */
    boolean hasPong();
    /**
     * <code>required string pong = 2;</code>
     */
    java.lang.String getPong();
    /**
     * <code>required string pong = 2;</code>
     */
    com.google.protobuf.ByteString
        getPongBytes();
  }
  /**
   * Protobuf type {@code domain.PingPongMessage}
   */
  public static final class PingPongMessage extends
      com.google.protobuf.GeneratedMessage
      implements PingPongMessageOrBuilder {
    // Use PingPongMessage.newBuilder() to construct.
    private PingPongMessage(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private PingPongMessage(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final PingPongMessage defaultInstance;
    public static PingPongMessage getDefaultInstance() {
      return defaultInstance;
    }

    public PingPongMessage getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private PingPongMessage(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      initFields();
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              bitField0_ |= 0x00000001;
              ping_ = input.readBytes();
              break;
            }
            case 18: {
              bitField0_ |= 0x00000002;
              pong_ = input.readBytes();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e.getMessage()).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.pablo.codec.PingPongPayload.internal_static_domain_PingPongMessage_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.pablo.codec.PingPongPayload.internal_static_domain_PingPongMessage_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.pablo.codec.PingPongPayload.PingPongMessage.class, org.pablo.codec.PingPongPayload.PingPongMessage.Builder.class);
    }

    public static com.google.protobuf.Parser<PingPongMessage> PARSER =
        new com.google.protobuf.AbstractParser<PingPongMessage>() {
      public PingPongMessage parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new PingPongMessage(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<PingPongMessage> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    // required string ping = 1;
    public static final int PING_FIELD_NUMBER = 1;
    private java.lang.Object ping_;
    /**
     * <code>required string ping = 1;</code>
     */
    public boolean hasPing() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required string ping = 1;</code>
     */
    public java.lang.String getPing() {
      java.lang.Object ref = ping_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          ping_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string ping = 1;</code>
     */
    public com.google.protobuf.ByteString
        getPingBytes() {
      java.lang.Object ref = ping_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        ping_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    // required string pong = 2;
    public static final int PONG_FIELD_NUMBER = 2;
    private java.lang.Object pong_;
    /**
     * <code>required string pong = 2;</code>
     */
    public boolean hasPong() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>required string pong = 2;</code>
     */
    public java.lang.String getPong() {
      java.lang.Object ref = pong_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          pong_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string pong = 2;</code>
     */
    public com.google.protobuf.ByteString
        getPongBytes() {
      java.lang.Object ref = pong_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        pong_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private void initFields() {
      ping_ = "";
      pong_ = "";
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) return isInitialized == 1;

      if (!hasPing()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasPong()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeBytes(1, getPingBytes());
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeBytes(2, getPongBytes());
      }
      getUnknownFields().writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(1, getPingBytes());
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(2, getPongBytes());
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }

    public static org.pablo.codec.PingPongPayload.PingPongMessage parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static org.pablo.codec.PingPongPayload.PingPongMessage parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static org.pablo.codec.PingPongPayload.PingPongMessage parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static org.pablo.codec.PingPongPayload.PingPongMessage parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static org.pablo.codec.PingPongPayload.PingPongMessage parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static org.pablo.codec.PingPongPayload.PingPongMessage parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static org.pablo.codec.PingPongPayload.PingPongMessage parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static org.pablo.codec.PingPongPayload.PingPongMessage parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static org.pablo.codec.PingPongPayload.PingPongMessage parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static org.pablo.codec.PingPongPayload.PingPongMessage parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(org.pablo.codec.PingPongPayload.PingPongMessage prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code domain.PingPongMessage}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder>
       implements org.pablo.codec.PingPongPayload.PingPongMessageOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return org.pablo.codec.PingPongPayload.internal_static_domain_PingPongMessage_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return org.pablo.codec.PingPongPayload.internal_static_domain_PingPongMessage_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                org.pablo.codec.PingPongPayload.PingPongMessage.class, org.pablo.codec.PingPongPayload.PingPongMessage.Builder.class);
      }

      // Construct using org.pablo.codec.PingPongPayload.PingPongMessage.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      private static Builder create() {
        return new Builder();
      }

      public Builder clear() {
        super.clear();
        ping_ = "";
        bitField0_ = (bitField0_ & ~0x00000001);
        pong_ = "";
        bitField0_ = (bitField0_ & ~0x00000002);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return org.pablo.codec.PingPongPayload.internal_static_domain_PingPongMessage_descriptor;
      }

      public org.pablo.codec.PingPongPayload.PingPongMessage getDefaultInstanceForType() {
        return org.pablo.codec.PingPongPayload.PingPongMessage.getDefaultInstance();
      }

      public org.pablo.codec.PingPongPayload.PingPongMessage build() {
        org.pablo.codec.PingPongPayload.PingPongMessage result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public org.pablo.codec.PingPongPayload.PingPongMessage buildPartial() {
        org.pablo.codec.PingPongPayload.PingPongMessage result = new org.pablo.codec.PingPongPayload.PingPongMessage(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.ping_ = ping_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.pong_ = pong_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof org.pablo.codec.PingPongPayload.PingPongMessage) {
          return mergeFrom((org.pablo.codec.PingPongPayload.PingPongMessage)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(org.pablo.codec.PingPongPayload.PingPongMessage other) {
        if (other == org.pablo.codec.PingPongPayload.PingPongMessage.getDefaultInstance()) return this;
        if (other.hasPing()) {
          bitField0_ |= 0x00000001;
          ping_ = other.ping_;
          onChanged();
        }
        if (other.hasPong()) {
          bitField0_ |= 0x00000002;
          pong_ = other.pong_;
          onChanged();
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        if (!hasPing()) {
          
          return false;
        }
        if (!hasPong()) {
          
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        org.pablo.codec.PingPongPayload.PingPongMessage parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (org.pablo.codec.PingPongPayload.PingPongMessage) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      // required string ping = 1;
      private java.lang.Object ping_ = "";
      /**
       * <code>required string ping = 1;</code>
       */
      public boolean hasPing() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required string ping = 1;</code>
       */
      public java.lang.String getPing() {
        java.lang.Object ref = ping_;
        if (!(ref instanceof java.lang.String)) {
          java.lang.String s = ((com.google.protobuf.ByteString) ref)
              .toStringUtf8();
          ping_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string ping = 1;</code>
       */
      public com.google.protobuf.ByteString
          getPingBytes() {
        java.lang.Object ref = ping_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          ping_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string ping = 1;</code>
       */
      public Builder setPing(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        ping_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string ping = 1;</code>
       */
      public Builder clearPing() {
        bitField0_ = (bitField0_ & ~0x00000001);
        ping_ = getDefaultInstance().getPing();
        onChanged();
        return this;
      }
      /**
       * <code>required string ping = 1;</code>
       */
      public Builder setPingBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        ping_ = value;
        onChanged();
        return this;
      }

      // required string pong = 2;
      private java.lang.Object pong_ = "";
      /**
       * <code>required string pong = 2;</code>
       */
      public boolean hasPong() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>required string pong = 2;</code>
       */
      public java.lang.String getPong() {
        java.lang.Object ref = pong_;
        if (!(ref instanceof java.lang.String)) {
          java.lang.String s = ((com.google.protobuf.ByteString) ref)
              .toStringUtf8();
          pong_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string pong = 2;</code>
       */
      public com.google.protobuf.ByteString
          getPongBytes() {
        java.lang.Object ref = pong_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          pong_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string pong = 2;</code>
       */
      public Builder setPong(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        pong_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string pong = 2;</code>
       */
      public Builder clearPong() {
        bitField0_ = (bitField0_ & ~0x00000002);
        pong_ = getDefaultInstance().getPong();
        onChanged();
        return this;
      }
      /**
       * <code>required string pong = 2;</code>
       */
      public Builder setPongBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        pong_ = value;
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:domain.PingPongMessage)
    }

    static {
      defaultInstance = new PingPongMessage(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:domain.PingPongMessage)
  }

  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_domain_PingPongMessage_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_domain_PingPongMessage_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016PingPong.proto\022\006domain\"-\n\017PingPongMess" +
      "age\022\014\n\004ping\030\001 \002(\t\022\014\n\004pong\030\002 \002(\tB\"\n\017org.p" +
      "ablo.codecB\017PingPongPayload"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          internal_static_domain_PingPongMessage_descriptor =
            getDescriptor().getMessageTypes().get(0);
          internal_static_domain_PingPongMessage_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_domain_PingPongMessage_descriptor,
              new java.lang.String[] { "Ping", "Pong", });
          return null;
        }
      };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
  }

  // @@protoc_insertion_point(outer_class_scope)
}
