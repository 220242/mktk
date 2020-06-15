:global telegramToken "API-KEY";
:global telegramUser "CHAT";
:local bootTimeFile "boot_time.txt";
:local systemTime [/system clock get time];
:local systemDate [/system clock get date];

/file print file=$bootTimeFile;
/file set $bootTimeFile contents="$systemDate $systemTime";

:local statusMessage "<b>Startup Status</b>%0AThe Router was rebooted%0Aat: <i>$systemTime</i>%0Aon: <i>$systemDate</i> startup";
:local tgUrl "https://api.telegram.org/bot$telegramToken/sendMessage?chat_id=$telegramUser&text=$statusMessage&parse_mode=html&disable_notification=true";
:delay 300;
/tool fetch url="$tgUrl" mode=http keep-result=no;
