


TIMES=$1


get_random_num(){
    local MIN=$1
    local MAX=$2
    RANDOM_NUM=$(( $RANDOM % (MAX - MIN + 1) + MIN ))
    echo "$RANDOM_NUM"
}

call_api() {
    
    RANDOM_ID=$(get_random_num 1 6)
    RANDOM_TIMER=$(get_random_num 2 10)

    curl -X POST http://localhost:3043/user \
     -H "Content-Type: application/json" \
     -d '{
            "id" : '"$RANDOM_ID"', 
            "timer": '"$RANDOM_TIMER"'
        }'
}




# defaults to 1 , ie call API only 1 time 
if [ -z "$TIMES" ] ; then
   TIMES=10
fi

# Iterate using for loop
for (( i=1; i<=$TIMES; i++ )); do
    call_api
    echo " done : [$i]/[$TIMES]"
    sleep 2
done


