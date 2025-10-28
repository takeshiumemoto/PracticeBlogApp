UPDATE blog_post
SET
 title = /*post.title*/'',
 content = /*post.content*/'',
 created_at = /*post.createdAt*/CURRENT_TIMESTAMP
WHERE 
 id = /*post.id*/0;