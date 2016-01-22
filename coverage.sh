echo YVALUE=`tail -n 7 target/coverage/index.html | head -n 1 | sed 's/.*>\(.*\)[.].*/\1/'` >> coverage_forms.property
echo YVALUE=`tail -n 5 target/coverage/index.html | head -n 1 | sed 's/.*>\(.*\)[.].*/\1/'` >> coverage_lines.property

