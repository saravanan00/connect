/**
 * #/getblog/id
 */
app.controller('BlogDetailsCtrl',function($scope,$rootScope,$location,$sce,BlogService,$routeParams)
		{ var id=$routeParams.id; 
		  $scope.rejectionTxt=false;
		 /* $scope.showComments=false;*/
		
		BlogService.getBlog(id).then(
				function(response){
					$scope.blog=response.data
					$scope.content=$sce.trustAsHtml($scope.blog.blogcontent)
				},function(response){
					$rootScope.error=response.data
					if(response.status==401)
						$location.path('/login');
				})
				BlogService.hasUserLikedBlog().then(
				function(response){
					if(response.data=='')
						$scope.isLiked=false
				else
					$scope.isLiked=true
				},function(response){
					$rootScope.error=response.data
					if(response.status==401)
						
						$location.path('/login')
				})
	$scope.approve=function(blog){
			BlogService.approve($scope.blog).then(
					function(response){
						$location.path('blogsnotapproved')
					},function(response){
						$rootScope.error=response.data
						if(response.status==401)
							$location.path('/login')
					})
		}
					$scope.reject=function(blog){
			BlogService.reject($scope.blog,$scope.rejectionReason).then(
					function(response){
						$location.path('blogsnotapproved')
					},function(response){
						$rootScope.error=response.data
						if(response.status==401)
							$location.path('/login')
					})
			
		}
					$scope.showRejectionTxt=function(){
						$scope.rejectionTxt=true;
					}
					$scope.updateLikes=function(id){
						BlogService.updateLikes(id).then(function(response){
							$scope.blog=response.data
							$scope.isLiked=!$scope.isLiked
						},function(response){
							$rootScope.error=response.data
							if(response.status==401)
								$location.path('/login')
						})
					}
					$scope.addComment=function(blog,commentTxt){
						$scope.blogComment={}
						$scope.blogComment.blogPost=blog;
						$scope.blogComment.commentTxt=commentTxt;
						BlogService.addComment($scope.blogComment).then(
								function(response){
									console.log('addcomment in controller')
									$scope.blogComment=response.data
									getBlogComments(id)
									$scope.commentTxt=''
								},function(response){
									$rootScope.error=response.data
									if(response.status==401)
										$location.path('/login')
										else{
											$scope.exceptionMessage=response.data
										}
											
								})
					}
					function getBlogComments(id){
						BlogService.getBlogComments(id).then(function(response){
							$scope.comments=response.data
						},
								function(response){
							$rootScope.error=response.data
							if(response.status==401)
								$location.path('/login')
						})
					}
          /* $scope.OnShowComments=function(){
        	   $scope.showComments=!$scope.showComments;
           }*/
           getBlogComments(id)
		})