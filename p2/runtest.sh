make clean
make
echo "****Running test on Identifiers****"
java P2 testfile/Identifiers.txt && diff testfile/Identifiers.txt.out testfile/Identifiers_Output.txt
echo "****Running test on Comment****"
java P2 testfile/Comment.txt && diff testfile/Comment.txt.out testfile/Comment_Output.txt
echo "****Running test on Illegal Character****"
java P2 testfile/Illegal_Character.txt 2>&1 | tee testfile/Illegal_Character.out && diff testfile/Illegal_Character.out testfile/Illegal_Character_Output.txt
echo "****Running test on Integer Literal****"
java P2 testfile/Integer_literal.txt && diff testfile/Integer_literal.txt.out testfile/Integer_literal_Output.txt
echo "****Running test on lengthy words****"
java P2 testfile/Lengthy_Words.txt 2>&1 | tee testfile/Lengthy_Words.out && diff testfile/Lengthy_Words.txt.out testfile/Lengthy_Words_Output.txt && diff testfile/Lengthy_Words.out testfile/Lengthy_Words_Error_Output.txt
echo "****Running test on reserved words****"
java P2 testfile/Reserved_words.txt && diff testfile/Reserved_words.txt.out testfile/Reserved_words_Output.txt

echo "****Running test on string literal 1****"
java P2 testfile/String_literal1.txt && diff testfile/String_literal1.txt.out testfile/String_literal1_Output.txt
echo "****Running test on string literal 2****"
java P2 testfile/String_literal2.txt && diff testfile/String_literal2.txt.out testfile/String_literal2_Output.txt
echo "****Running test on string literal 3****"
java P2 testfile/String_literal3.txt 2>&1 | tee testfile/String_literal3.out && diff testfile/String_literal3.out testfile/String_literal3_Output.txt
echo "****Running test on string literal 4****"
java P2 testfile/String_literal4.txt 2>&1 | tee testfile/String_literal4.out && diff testfile/String_literal4.txt.out testfile/String_literal4_Output.txt && diff testfile/String_literal4.out testfile/String_literal4_warn_Output.txt
echo "***********************TEST END***************************************************"
