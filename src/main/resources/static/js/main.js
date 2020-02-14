// 提交评论
function post(id, type, content) {
    if (!content) {
        alert("评论内容不能为空！");
        return;
    }
    $.ajax({
        url: "/comment",
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify({
            "parentId": id,
            "content": content,
            "type": type
        }),
        success: function (response) {
            if (response.code == 200) {
                window.location.reload();
            } else {
                if (response.code == 2003) {
                    let confirm = window.confirm("未登录，请先登录！");
                    if (confirm) {
                        window.open("https://github.com/login/oauth/authorize?client_id=2dee127350ab978c4543&redirect_uri=http://localhost:8887/callback&scope=user&state=1");
                        window.localStorage.setItem("closable", true);
                    }
                } else {
                    alert(response.message);
                }
            }
        },
        dataType: "json"
    });
};

function comment(e) {
    var questionId = $("#questionId").val();
    var content = $("#comment_content").val();
    post(questionId, 1, content);
}

function reply(e) {
    var commentId = e.getAttribute("data-id");
    var content = $("#reply-" + commentId).val();
    post(commentId, 2, content);
}
//点赞
function incLike() {

}

//显示二级评论
function collapseComment(e) {
    let id = e.getAttribute("data-id");
    let comment = $("#comment-" + id);
    let collapse = e.getAttribute("data-collapse");
    if (collapse) {

        comment.removeClass("in");
        e.removeAttribute("data-collapse");
        e.classList.remove("active");
    } else {
        let subCommentContainer = $("#comment-" + id);
        if (subCommentContainer.children().length === 1) {

            $.getJSON(
                "/comment/" + id, function (data) {
                    $.each(data.data.reverse(), function (index, comment) {
                        let mediaLeftElement = $("<div/>", {
                            "class": "media-left"
                        }).append($("<img/>", {
                            "class": "media-object img-rounded media-object-img-size",
                            "src": comment.user.avatarUrl
                        }));

                        let mediaBodyElement = $("<div/>", {
                            "class": "media-body text-desc",
                        }).append($("<h6/>", {
                            "class": "media-heading",
                            html: comment.user.name
                        })).append($("<span/>", {
                            html: comment.content
                        })).append($("<span/>", {
                            "class": "btn-publish",
                            html: moment(comment.gmtCreate).format('YYYY-MM-DD')
                        }));

                        let media = $("<div/>", {
                            "class": "media"
                        }).append(mediaLeftElement).append(mediaBodyElement);

                        let commentElement = $("<div/>", {
                            "class": "col-lg-12 col-md-12 col-sm-12 col-xs-12",
                        }).append(media);
                        subCommentContainer.prepend(commentElement);
                    });
                }
            )
        }
        comment.addClass("in");
        e.setAttribute("data-collapse", "in");
        e.classList.add("active");
    }
};

function hideTags() {
    // $('#select-tag').hide();
};

function showTags() {
        $('#select-tag').show();
};

function selectTag(e) {
    let tag = e.getAttribute("data-tag");
    let tags = $("#tag").val();
    console.log("tag:"+tag+",tags:"+tags);
    if (tags.indexOf(tag) === -1) {
        if (tags) {
            console.log("111");
            $("#tag").val(tags + "," + tag);
        } else {
            console.log("222");
            $("#tag").val(tag);
        };
    }
}