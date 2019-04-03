<template>
	<view class="container">
		<view class="top">
			<view class="avatar-box">
				<image
					src="../../static/default.png"
					mode="scaleToFill"
					class="avatar"
					v-if="!storageData.login">
					</image>
				<image
					:src="storageData.avatar"
					mode="scaleToFill"
					class="avatar"
					v-if="storageData.login"
				></image>
			</view>
			<view class="info-box">
				<navigator url="../signin/signin" v-if="!storageData.login">点击登录</navigator>
				<text v-if="storageData.login" class="text">{{ storageData.nickname }}</text>
				<navigator v-if="storageData.login" url="../setting/setting" class="setting">个人设置</navigator>
			</view>
		</view>
		<view class="header" v-if="storageData.login">
			<view v-for="(header,index) in headers" :key="index" class="header1">
			<navigator >{{header.shang}}</navigator>
			<navigator>{{header.xia}}</navigator>
			</view>
		</view>
	
	<view class="content" v-if="storageData.login">
		<view v-for="(content,index) in contents" :key="index" class="content1">
			<view class="content2">
		<navigator>{{content.wenzhang}}</navigator>	
		</view>
		</view>
	</view>
	</view>
</template>

<script>
var loginRes, _self;
export default {
	data() {
		var one=10;
		var two=5;
		var three=66;
		var four=100;
		return {
			storageData: {},
			headers:[{
				"shang":one,
				"xia":'文章'
			},{
				"shang":two,
				"xia":'关注'
			},
			{
				"shang":three,
				"xia":'消息'
			},
			{
				"shang":four,
				"xia":'积分'
			}
			],
			contents:[{
				"wenzhang":'第一篇文章'
			},
			{
				"wenzhang":'第二篇文章'
			},
			{
				"wenzhang":'第三篇文章'
			},
			{
				"wenzhang":'第四篇文章'
			}]
			
		};
	},
	onLoad: function() {},
	onShow: function() {
		const loginKey = uni.getStorageSync('login_key');
		console.log("come");
		if (loginKey) {
			console.log(loginKey);
			this.storageData = {
				login: loginKey.login,
				nickname: loginKey.nickname,
				avatar: loginKey.avatar
			};
		}else{
			this.storageData ={
				login: false
			}
		}
	},
	methods: {
		
	}
};
</script>

<style scoped>
	.content2{
		display: flex;
		align-content: center;
		height: 30px;
	}
	.container{
		height: 100%;
	}
	.header{
		display: flex;
		width: 100%;
		margin-bottom: 20px;
		margin-top: 40px;
	}
	.header1{
		width: 70%;
		margin-right: 10px;
		text-align: center;
		margin-left: 15px;
		border-right: 1px solid #8F8F94;
		margin-top: 30px;
	}
	.content{
	margin-top: 20px;
	}
	.content1{	
		display: flex;
		border-bottom: 1px solid #8F8F94;
		margin-bottom: 20px;
		align-content: center;
	}
	.top {
	height: 70px;
	margin-top: 15px;
	margin-bottom: 20px;
}
.avatar-box{
	text-align: center;
	margin-bottom: 15px;
}
.info-box{
	display: flex;
	justify-content: center;
}
.text{
	display: flex;
	margin-right: 25px;
	text-align: center;
	margin-bottom: 15px;
}
.setting{
	display: flex;
	text-align: center;
	margin-left: 10px;
     color:rgb(26, 173, 25);
}

</style> 