//
//  Cell.m
//  WorkForIt
//
//  Created by Nitesh on 11/22/14.
//  Copyright (c) 2014 Nitesh. All rights reserved.
//

#import "Cell.h"

@implementation Cell

- (id)initWithChore:(NSString *)aChore
               earned:(int)aEarned
{
    if( self = [super init] )
    {
        _chore = aChore;
        _earned = aEarned;
    }
    
    return self;
}



@end
