package com.javaweb.config.nettywebsocket;

import java.time.Duration;

import org.springframework.core.env.Environment;
import org.springframework.data.redis.core.RedisTemplate;

import com.javaweb.constant.CommonConstant;
import com.javaweb.constant.SystemConstant;
import com.javaweb.context.ApplicationContextHelper;
import com.javaweb.util.core.SecretUtil;
import com.javaweb.web.eo.TokenData;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;
import net.sf.json.JSONObject;

//若要被Controller调用加上@Service即可
public class NettyWebSocketServerHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {
	
	private RedisTemplate<String,Object> redisTemplate = null;
	
	private Environment environment = null;
	
	public static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

	@SuppressWarnings("unchecked")
	protected void channelRead0(ChannelHandlerContext channelHandlerContext, TextWebSocketFrame textWebSocketFrame) throws Exception {
		String content = textWebSocketFrame.text();
		//System.out.println("接收到客户端的消息为:"+content);
		if(redisTemplate==null){
			redisTemplate = (RedisTemplate<String,Object>)ApplicationContextHelper.getBean(SystemConstant.REDIS_TEMPLATE);
		}
		if(environment==null){
			environment = (Environment)ApplicationContextHelper.getBean(SystemConstant.ENVIRONMENT);
		}
		Long redisSessionTimeout = Long.parseLong(environment.getProperty("redis.session.timeout"));//获得配置文件中redis设置session失效的时间
		String token = CommonConstant.NULL_VALUE;
		try{
			token = JSONObject.fromObject(content).getString(SystemConstant.HEAD_TOKEN);
			token = SecretUtil.base64DecoderString(token,"UTF-8");
	    	String tokens[] = token.split(CommonConstant.COMMA);//token由三部分组成：token,userId,type
	    	token = tokens[1]+CommonConstant.COMMA+tokens[2];//userId+type
		}catch(Exception e){
			//do nothing
		}
		TokenData tokenData = (TokenData)redisTemplate.opsForValue().get(token);
		if(tokenData!=null){
			sendMessageToAll(content);
			redisTemplate.opsForValue().set(token,tokenData,Duration.ofMinutes(redisSessionTimeout));
		}else{
			this.channelInactive(channelHandlerContext);
		}
		//sendMessageToOne("指定某人发信息",channelHandlerContext);
		//sendMessageToAll("给所有人发信息");
	}

	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		//System.out.println("与客户端建立连接");
		channelGroup.add(ctx.channel());
	}

	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		//System.out.println("与客户端断开连接");
		channelGroup.remove(ctx.channel());
	}
	
	//给指定的人发消息
	public void sendMessageToOne(String message,ChannelHandlerContext ctx){
		ctx.channel().writeAndFlush(new TextWebSocketFrame(message));
	}
	
	//给所有人发消息
	public void sendMessageToAll(String message){
		channelGroup.writeAndFlush(new TextWebSocketFrame(message));
	}
	
}
