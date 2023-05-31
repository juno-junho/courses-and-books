[This branch has conflicts that must be resolved 문제 해결 방법]
- 참고 링크 :  [stackoverflow](https://stackoverflow.com/questions/56683681/this-branch-has-conflicts-that-must-be-resolved-but-its-already-merged)
- 방법 :
    -  git checkout juno-junho
    - git pull upstream juno-junho
    - git checkout step5
    - git merge juno-junho -> conflict 해결
    - git add > commit > push