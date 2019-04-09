<template>
	<view>
	<view class="content">
		<view class="top-content">
			<view class="top-box">
				<image class="img" src="../../static/commentflashnews.png"></image>
				<text>互动消息</text>
			</view>
			<view class="top-box">
				<image class="img" src="../../static/钻石.png"></image>
				<text>简阅钻</text>
			</view>
			<view class="top-box">
				<image class="img" src="../../static/bell.png"></image>
				<text>其他信息</text>
			</view>
		</view>
		</view>
		<hr/>
		<view class="content">
		<view class="box">
			<image class="img" src="../../static/关注.png"></image>
			<navigator class="navbar">关注信息</navigator>
		</view>
		<view class="box">
			<image  class="img"  src="../../static/访问.png"></image>
			<navigator class="navbar">最近来访</navigator>
		</view>
		<view class="box">
			<image class="img" src="../../static/信息.png"></image>
			<navigator class="navbar">系统信息</navigator>
		</view>
		<view class="box">
			<image class="img" src="../../static/记录.png"></image>
			<navigator class="navbar">浏览记录</navigator>
		</view>
		<view class="box">
			<image class="img" src="../../static/wallet.png"></image>
			<navigator class="navbar">钱包</navigator>
		</view>
		<view class="box">
			<image class="img" src="../../static/收藏.png"></image>
			<navigator class="navbar">我的收藏</navigator>
		</view>
	</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
	
			};
		},
		onLoad() {
	
		},
		onShow() {
	
		},
		methods: {
	
		}
	}
</script>

<style scoped="scoped">
	.top-content{
		width: 90%;
		margin: 0 auto;
		display: flex;
		height: 250upx;
		align-items: center;
	}
	.top-box{
		align-items: center;
		flex: 1 1 33.33%;
		display: flex;
		flex-direction: column;
	}
	hr{
		border: 5upx solid #EEEEEE;
	}
	.content{
		width: 90%;
		margin: 0 auto;
		display: flex;
		flex-direction: column;
	}
	.box{
		height: 100upx;
		display: flex;
		align-items: center;
		font-size: 50upx;
		margin-top: 20upx;
	}
	.navbar{
		margin-left: 20upx;
		flex: 1 1 85%;
		height: 100upx;
		display: flex;
		align-items: center;
		border-bottom: 1px solid #D3D3D3;
	}
	.img{
		width:80upx;
		height:80upx;
	}
</style>
